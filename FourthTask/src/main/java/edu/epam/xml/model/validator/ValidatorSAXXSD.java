package edu.epam.xml.model.validator;

import edu.epam.xml.model.exception.CustomParsingXMLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;

public class ValidatorSAXXSD {
    private static Logger logger = LogManager.getLogger();

    public void validate(InputStream inputStream) throws CustomParsingXMLException {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String schemaName = "/candy.xsd";

        SchemaFactory factory = SchemaFactory.newInstance(language);
        ClassLoader classLoader = getClass().getClassLoader();
        File schemaLocation = new File(classLoader.getResource(schemaName).getFile());

        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(inputStream);
            validator.validate(source);
            logger.info("File is valid.");
        } catch (SAXException | IOException e) {
            logger.fatal("File is not valid.", e);
            throw new CustomParsingXMLException("File is not valid.", e);
        }
    }
}
