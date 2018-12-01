package edu.epam.xml.model.command.impl;

import edu.epam.xml.model.exception.CustomParsingXMLException;
import edu.epam.xml.model.command.Command;
import edu.epam.xml.model.entity.Candy;
import edu.epam.xml.model.util.PagePath;
import edu.epam.xml.model.parser.AbstractCandyBuilder;
import edu.epam.xml.model.parser.CandyBuilderFactory;
import edu.epam.xml.model.validator.ValidatorSAXXSD;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ParsingCommand implements Command {
    private static final String SAX = "SAX";
    private static final String DOM = "DOM";
    private static final String STAX = "STAX";

    private static final String PARAM_NAME_PARSER = "parser";
    private static final String PARAM_NAME_FILE = "file";
    private static final String ATTRIBUTE_ERROR_NAME = "errorLoginPassMessage";
    private static final String ATTRIBUTE_ERROR_VALUE = "Error while validating parser name.";
    private static final String UPLOAD_DIR = "uploads";

    private static Logger logger = LogManager.getLogger();

    public String execute(HttpServletRequest request) throws IOException, ServletException, CustomParsingXMLException {
        String page = PagePath.PARSING_PATH;
        String parser = request.getParameter(PARAM_NAME_PARSER);

        boolean check = parser.equalsIgnoreCase(SAX) || parser.equalsIgnoreCase(DOM) || parser.equalsIgnoreCase(STAX);
        if (check) {
            if (request.getAttribute(ATTRIBUTE_ERROR_NAME) != null){
                request.removeAttribute(ATTRIBUTE_ERROR_NAME);
            }

            String applicationPath = request.getServletContext().getRealPath("");
            System.out.println("APP PATH: " + applicationPath);
            String uploadFilePath = applicationPath + UPLOAD_DIR;
            System.out.println("UPLOADED_PATH: " + uploadFilePath);

            File fileSaveDir = new File(uploadFilePath);
            if(!fileSaveDir.exists()){
                fileSaveDir.mkdirs();
            }

            String formedPath = null;

            Part part = request.getPart(PARAM_NAME_FILE);

            if (part.getSubmittedFileName() != null) {
                formedPath = uploadFilePath + File.separator + part.getSubmittedFileName();
                part.write(formedPath);
            }


            //todo: ask two streams uestion
            FileInputStream validatorIs = new FileInputStream(formedPath);
            InputStream inputStream = part.getInputStream();

            ValidatorSAXXSD validator = new ValidatorSAXXSD();
            validator.validate(validatorIs);

            CandyBuilderFactory candyFactory = new CandyBuilderFactory();
            AbstractCandyBuilder builder = candyFactory.createCandyBuilder(parser.toUpperCase());
            builder.buildSetCandies(inputStream);

            Set<Candy> candies = builder.getCandies();

            List<Candy> list = new ArrayList<>(candies);
            request.setAttribute("list", list);

        }
        else {
            logger.warn("Incorrect parser name : " + parser);
            request.setAttribute(ATTRIBUTE_ERROR_NAME, ATTRIBUTE_ERROR_VALUE);
            page = PagePath.INDEX_PATH;
        }
        return page;
    }
}
