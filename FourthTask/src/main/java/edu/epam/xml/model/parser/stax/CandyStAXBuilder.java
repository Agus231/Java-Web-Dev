package edu.epam.xml.model.parser.stax;

import edu.epam.xml.model.exception.CustomParsingXMLException;
import edu.epam.xml.model.entity.*;
import edu.epam.xml.model.entity.component.Ingredients;
import edu.epam.xml.model.entity.component.Values;
import edu.epam.xml.model.parser.AbstractCandyBuilder;
import edu.epam.xml.model.util.DateXMLFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Date;

import static edu.epam.xml.model.entity.SimpleCandy.SimpleCandyType;
import static edu.epam.xml.model.entity.ChocolateCandy.ChocolateCandyType;

public class CandyStAXBuilder extends AbstractCandyBuilder {
    private XMLInputFactory inputFactory;
    private static Logger logger = LogManager.getLogger();

    public CandyStAXBuilder(){
        inputFactory = XMLInputFactory.newInstance();
    }

    public void buildSetCandies(InputStream source) throws CustomParsingXMLException {
        String name;
        XMLStreamReader reader = null;
        try {
            reader = inputFactory.createXMLStreamReader(source);

            while (reader.hasNext()){
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT){
                    name = reader.getLocalName();
                    if (CandyEnum.valueOf(CandyEnum.toEnumFormat(name)) == CandyEnum.SIMPLE_CANDY){
                        SimpleCandy candy = (SimpleCandy) buildCandy(reader, CandyEnum.SIMPLE_CANDY);
                        candies.add(candy);
                    }
                    else if(CandyEnum.valueOf(CandyEnum.toEnumFormat(name)) == CandyEnum.CHOCOLATE_CANDY){
                        ChocolateCandy candy = (ChocolateCandy) buildCandy(reader, CandyEnum.CHOCOLATE_CANDY);
                        candies.add(candy);
                    }
                }
            }
        } catch (XMLStreamException e) {
            throw new CustomParsingXMLException("Exception while parsing(StAX)", e);
        }
        finally {
            try {
                if (reader != null){
                    reader.close();
                }
            } catch (XMLStreamException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    private Candy buildCandy(XMLStreamReader reader, CandyEnum candyType) throws XMLStreamException {
        Candy candy;

        switch (candyType){
            case SIMPLE_CANDY:
                candy = new SimpleCandy();
                String simpleTypeName = reader.getAttributeValue(null, CandyEnum.TYPE.getTag());

                SimpleCandyType simpleType = SimpleCandyType.valueOf(simpleTypeName.toUpperCase());
                candy.setType(simpleType);
                break;
            case CHOCOLATE_CANDY:
                candy = new ChocolateCandy();
                String complexTypeName = reader.getAttributeValue(null, CandyEnum.TYPE.getTag());

                ChocolateCandyType complexType = ChocolateCandyType.valueOf(ChocolateCandyType.toEnumFormat(complexTypeName));
                candy.setType(complexType);
                break;
                default:
                    throw new EnumConstantNotPresentException(CandyEnum.class, "Constant " + candyType + "can't present in this context.");
        }

        candy.setCandyId(reader.getAttributeValue(null, CandyEnum.ID.getTag()));

        String name;
        while (reader.hasNext()){
            int type = reader.next();
            switch (type) {
                case (XMLStreamConstants.START_ELEMENT):
                    name = reader.getLocalName();
                    switch (CandyEnum.valueOf(CandyEnum.toEnumFormat(name))){
                        case NAME:
                            candy.setName(getXMLText(reader));
                            break;
                        case ENERGY:
                            name = getXMLText(reader);
                            candy.setEnergy(Integer.parseInt(name));
                            break;
                        case PRODUCTION:
                            candy.setProduction(getXMLText(reader));
                            break;
                        case PRODUCED_DATE:
                            name = getXMLText(reader);
                            try {
                                Date date = DateXMLFilter.parseDate(name);
                                candy.setProducedDate(date);
                            } catch (ParseException e) {
                                logger.error(e.getMessage(), e);
                            }
                            break;
                        case VALUES:
                            candy.setValues(getXMLValues(reader));
                            break;
                        case INGREDIENTS:
                            candy.setIngredients(getXMLIngredients(reader));
                            break;
                        case CHOCOLATE_TYPE:
                            ((ChocolateCandy)candy).setChocolateType(getXMLText(reader));
                            break;
                    }
                    break;
                case (XMLStreamConstants.END_ELEMENT):
                    name = reader.getLocalName();

                    if (CandyEnum.valueOf(CandyEnum.toEnumFormat(name)) == CandyEnum.SIMPLE_CANDY ||
                            CandyEnum.valueOf(CandyEnum.toEnumFormat(name)) == CandyEnum.CHOCOLATE_CANDY){
                        return candy;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag ...-candy");
    }

    private Ingredients getXMLIngredients(XMLStreamReader reader) throws XMLStreamException {
        Ingredients ingredients = new Ingredients();
        int type;
        String name;
        while (reader.hasNext()){
            type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandyEnum.valueOf(name.toUpperCase())){
                        case WATER:
                            name = getXMLText(reader);
                            ingredients.setWater(Integer.parseInt(name));
                            break;
                        case SUGAR:
                            name = getXMLText(reader);
                            ingredients.setSugar(Integer.parseInt(name));
                            break;
                        case FRUCTOSE:
                            name = getXMLText(reader);
                            ingredients.setFructose(Integer.parseInt(name));
                            break;
                        case VANILLA:
                            name = getXMLText(reader);
                            ingredients.setVanilla(Integer.parseInt(name));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandyEnum.valueOf(name.toUpperCase()) == CandyEnum.INGREDIENTS){
                        return ingredients;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag ingredients.");
    }

    private Values getXMLValues(XMLStreamReader reader) throws XMLStreamException {
        Values values = new Values();
        int type;
        String name;
        while (reader.hasNext()){
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandyEnum.valueOf(name.toUpperCase())) {
                        case PROTEINS:
                            name = getXMLText(reader);
                            values.setProteins(Integer.parseInt(name));
                            break;
                        case FATS:
                            name = getXMLText(reader);
                            values.setFats(Integer.parseInt(name));
                            break;
                        case STARCHES:
                            name = getXMLText(reader);
                            values.setStarches(Integer.parseInt(name));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandyEnum.valueOf(name.toUpperCase()) == CandyEnum.VALUES) {
                        return values;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag values.");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()){
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
