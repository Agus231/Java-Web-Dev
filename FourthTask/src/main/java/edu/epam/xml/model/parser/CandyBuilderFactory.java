package edu.epam.xml.model.parser;

import edu.epam.xml.model.exception.CustomParsingXMLException;
import edu.epam.xml.model.parser.dom.CandyDOMBuilder;
import edu.epam.xml.model.parser.sax.CandySAXBuilder;
import edu.epam.xml.model.parser.stax.CandyStAXBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CandyBuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }

    private static Logger logger = LogManager.getLogger();

    public AbstractCandyBuilder createCandyBuilder(String typeParser) throws CustomParsingXMLException {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());

        logger.info("Preparing parser " + type.name() + ".");

        switch (type) {
            case DOM:
                return new CandyDOMBuilder();
            case SAX:
                return new CandySAXBuilder();
                default:
                    return new CandyStAXBuilder();
            }
    }
}
