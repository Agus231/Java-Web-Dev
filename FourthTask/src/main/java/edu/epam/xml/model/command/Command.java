package edu.epam.xml.model.command;

import edu.epam.xml.controller.SessionRequestContent;

public interface Command {
    String execute(SessionRequestContent request);
}
