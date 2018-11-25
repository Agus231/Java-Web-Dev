package edu.epam.xml.model.command;

import edu.epam.xml.model.exception.CustomParsingXMLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class CommandFactory {
    private static final String PARAMETER_NAME = "command";
    private static Logger logger = LogManager.getLogger();

    public Command defineCommand(HttpServletRequest request) throws CustomParsingXMLException {
        String action = request.getParameter(PARAMETER_NAME);

        if (action == null){
            throw new CustomParsingXMLException("Exception while getting request parameter : " + PARAMETER_NAME);
        }

        CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
        logger.info("Command that servlet got is " + currentEnum.name());
        return currentEnum.getCommand();
    }
}
