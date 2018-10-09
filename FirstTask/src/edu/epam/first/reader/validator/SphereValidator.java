package edu.epam.first.reader.validator;

public class SphereValidator {
    private final static String INPUT_REGEX = "([-+]?\\d+\\.?\\d+([eE][-+]?\\d+)?(\\s+)){3}(\\+?)\\d+\\.?\\d+([eE][-+]?\\d+)?((\\s+)|$)";

    public boolean validateLine(String str) {
        if (!str.matches(INPUT_REGEX)){
            return false;
        }

        return true;
    }
}
