package edu.epam.first.reader.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereValidator {
    private final static String INPUT_REGEX = "([-+]?\\d+\\.?\\d+([eE][-+]?\\d+)?(\\s+)){3}(\\+?)\\d+\\.?\\d+([eE][-+]?\\d+)?((\\s+)|$)";
    private static Logger logger = LogManager.getLogger();

    public boolean validateLine(String str) {
        if (!str.matches(INPUT_REGEX)){
            logger.warn("String : " + str + "; FALSE WHILE VALIDATING");
            return false;
        }

        return true;
    }
}
