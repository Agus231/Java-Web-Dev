package edu.epam.xml.model.parser.sax;

import edu.epam.xml.model.exception.CustomParsingXMLException;
import edu.epam.xml.model.parser.AbstractCandyBuilder;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

public class CandySAXBuilder extends AbstractCandyBuilder {
    private CandyHandler handler;
    private XMLReader reader;

    public CandySAXBuilder() throws CustomParsingXMLException {
        handler = new CandyHandler();
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        try{
            SAXParser parser = parserFactory.newSAXParser();

            reader = parser.getXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException e) {
            throw new CustomParsingXMLException("Exception while getting reader(SAX).", e);
        } catch (ParserConfigurationException e) {
            throw new CustomParsingXMLException("Exception while getting parser(SAX).", e);
        }
    }

    public void buildSetCandies(InputStream file) throws CustomParsingXMLException {
        try{
            reader.parse(new InputSource(file));
        } catch (SAXException e) {
            throw new CustomParsingXMLException("Exception while parsing(SAX).", e);
        } catch (IOException e) {
            throw new CustomParsingXMLException("Exception while working with the resource.", e);
        }

        candies = handler.getCandies();
    }
}
