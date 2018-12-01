package edu.epam.xml.model.command;

import edu.epam.xml.model.exception.CustomParsingXMLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface Command {
    String execute(HttpServletRequest request) throws IOException, ServletException, CustomParsingXMLException;
}
