package edu.epam.xml.model.command.impl;

import edu.epam.xml.controller.SessionRequestContent;
import edu.epam.xml.model.exception.CustomParsingXMLException;
import edu.epam.xml.model.command.Command;
import edu.epam.xml.model.entity.Candy;
import edu.epam.xml.model.util.PagePath;
import edu.epam.xml.model.parser.AbstractCandyBuilder;
import edu.epam.xml.model.parser.CandyBuilderFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ParsingCommand implements Command {
    private static final String SAX = "SAX";
    private static final String DOM = "DOM";
    private static final String STAX = "STAX";

    private static final String PARAM_NAME_PARSER = "parser";
    private static final String ATTRIBUTE_NAME = "errorLoginPassMessage";
    private static final String ATTRIBUTE_ERROR_VALUE = "Error while validating parser name.";

    private static Logger logger = LogManager.getLogger();

    public String execute(SessionRequestContent request) {
        String page = PagePath.PARSING_PATH;
        String parser = request.getParameter(PARAM_NAME_PARSER);

        boolean check = parser.equalsIgnoreCase(SAX) || parser.equalsIgnoreCase(DOM) || parser.equalsIgnoreCase(STAX);
        if (check) {
            InputStream is = getClass().getResourceAsStream("/candy.xml");

            try {
            CandyBuilderFactory candyFactory = new CandyBuilderFactory();
            AbstractCandyBuilder builder = candyFactory.createCandyBuilder(parser.toUpperCase());
            builder.buildSetCandies(is);

            Set<Candy> candies = builder.getCandies();

            List<Candy> list = new ArrayList<>(candies);
            request.setAttribute("list", list);

            } catch (CustomParsingXMLException e) {
                logger.error(e.getMessage(), e);
            }
        }
        else {
            logger.warn("Incorrect parser name : " + parser);
            request.setAttribute(ATTRIBUTE_NAME, ATTRIBUTE_ERROR_VALUE);
            page = PagePath.INDEX_PATH;
        }
        return page;
    }
}
