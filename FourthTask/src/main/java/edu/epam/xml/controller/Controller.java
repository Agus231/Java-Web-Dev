package edu.epam.xml.controller;

import edu.epam.xml.model.exception.CustomParsingXMLException;
import edu.epam.xml.model.command.Command;
import edu.epam.xml.model.command.CommandFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//todo: add validator

@WebServlet("/Controller")
@MultipartConfig( fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class Controller extends HttpServlet {
    private static Logger logger = LogManager.getLogger();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Servlet " + getServletName() + " got request.");
        CommandFactory factory = new CommandFactory();

        Command command;
        String page;
        RequestDispatcher dispatcher;

        try {
            command = factory.defineCommand(request);

            page = command.execute(request);
            dispatcher = getServletContext().getRequestDispatcher(page);

            dispatcher.forward(request, response);
        } catch (CustomParsingXMLException e) {
            logger.error(e.getMessage(), e);
            //exception настроен в web.xml
            throw new ServletException(e);
        }
    }
}
