package edu.epam.xml.model.exception;

public class CustomParsingXMLException extends Exception {
    public CustomParsingXMLException() {
    }

    public CustomParsingXMLException(String message) {
        super(message);
    }

    public CustomParsingXMLException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomParsingXMLException(Throwable cause) {
        super(cause);
    }
}
