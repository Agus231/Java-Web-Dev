package edu.epam.xml.controller;

import edu.epam.xml.model.exception.CustomParsingXMLException;
import edu.epam.xml.model.command.Command;
import edu.epam.xml.model.command.CommandFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private static Logger logger = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Servlet " + getServletName() + " got request.");
        CommandFactory factory = new CommandFactory();
        SessionRequestContent sessionRequestContent = new SessionRequestContent();

        Command command;
        String page;
        RequestDispatcher dispatcher;

        try {
            command = factory.defineCommand(request);
            sessionRequestContent.extractValues(request);

            page = command.execute(sessionRequestContent);
            dispatcher = getServletContext().getRequestDispatcher(page);
            sessionRequestContent.importValues(request);

            dispatcher.forward(request, response);
        } catch (CustomParsingXMLException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
