package edu.epam.xml.model.parser.dom;

import edu.epam.xml.model.exception.CustomParsingXMLException;
import edu.epam.xml.model.entity.*;
import edu.epam.xml.model.entity.Ingredients;
import edu.epam.xml.model.entity.Values;
import edu.epam.xml.model.parser.AbstractCandyBuilder;

import edu.epam.xml.model.util.DateXMLFilter;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Date;

import static edu.epam.xml.model.entity.SimpleCandy.SimpleCandyType;
import static edu.epam.xml.model.entity.ChocolateCandy.ChocolateCandyType;

public class CandyDOMBuilder extends AbstractCandyBuilder {
    private DocumentBuilder documentBuilder;

    public CandyDOMBuilder() throws CustomParsingXMLException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new CustomParsingXMLException("Exception while creating DOMBuilder.", e);
        }
    }

    public void buildSetCandies(InputStream source) throws CustomParsingXMLException {
        Document document;
        try{
            document = documentBuilder.parse(source);
            Element root = document.getDocumentElement();

            NodeList simpleCandiesList = root.getElementsByTagName(CandyEnum.SIMPLE_CANDY.getTag());
            for (int i = 0; i < simpleCandiesList.getLength(); i++) {
                Element simpleCandyElement = (Element) simpleCandiesList.item(i);
                SimpleCandy simpleCandy = buildSimpleCandy(simpleCandyElement);
                candies.add(simpleCandy);
            }

            NodeList chocolateCandiesList = root.getElementsByTagName(CandyEnum.CHOCOLATE_CANDY.getTag());
            for (int i = 0; i < chocolateCandiesList.getLength(); i++) {
                Element chocolateCandyElement = (Element) chocolateCandiesList.item(i);
                ChocolateCandy chocolateCandy = buildChocolateCandy(chocolateCandyElement);
                candies.add(chocolateCandy);
            }
        } catch (SAXException e) {
            throw new CustomParsingXMLException("Exception while parsing(DOM).", e);
        } catch (IOException e) {
            throw new CustomParsingXMLException("Missing resource.", e);
        }
    }

    private Candy buildCandy(Element candyElement, CandyEnum candyType) throws CustomParsingXMLException {
        Candy candy;
        switch (candyType){
            case SIMPLE_CANDY:
                candy = new SimpleCandy();
                break;
            case CHOCOLATE_CANDY:
                candy = new ChocolateCandy();
                break;
                default:
                    throw new EnumConstantNotPresentException(CandyEnum.class, "Constant " + candyType + "can't present in this context.");
        }

        String id = candyElement.getAttribute(CandyEnum.ID.getTag());
        candy.setCandyId(id);

        candy.setName(getElementTextContext(candyElement, CandyEnum.NAME.getTag()));

        Integer energy = Integer.parseInt(getElementTextContext(candyElement, CandyEnum.ENERGY.getTag()));
        candy.setEnergy(energy);

        Values values = candy.getValues();
        Element valuesElement = (Element) candyElement.getElementsByTagName(CandyEnum.VALUES.getTag()).item(0);

        Integer proteins = Integer.parseInt(getElementTextContext(valuesElement, CandyEnum.PROTEINS.getTag()));
        Integer fats = Integer.parseInt(getElementTextContext(valuesElement, CandyEnum.FATS.getTag()));
        Integer starches = Integer.parseInt(getElementTextContext(valuesElement, CandyEnum.STARCHES.getTag()));

        values.setProteins(proteins);
        values.setFats(fats);
        values.setStarches(starches);

        Ingredients ingredients = candy.getIngredients();
        Element ingredientsElement = (Element) candyElement.getElementsByTagName(CandyEnum.INGREDIENTS.getTag()).item(0);

        Integer water = Integer.parseInt(getElementTextContext(ingredientsElement, CandyEnum.WATER.getTag()));
        Integer sugar = Integer.parseInt(getElementTextContext(ingredientsElement, CandyEnum.SUGAR.getTag()));
        Integer fructose = Integer.parseInt(getElementTextContext(ingredientsElement, CandyEnum.FRUCTOSE.getTag()));
        Integer vanilla = Integer.parseInt(getElementTextContext(ingredientsElement, CandyEnum.VANILLA.getTag()));

        ingredients.setWater(water);
        ingredients.setSugar(sugar);
        ingredients.setFructose(fructose);
        ingredients.setVanilla(vanilla);

        candy.setProduction(getElementTextContext(candyElement, CandyEnum.PRODUCTION.getTag()));
        String dateString = getElementTextContext(candyElement, CandyEnum.PRODUCED_DATE.getTag());

        try {
            Date date = DateXMLFilter.parseDate(dateString);
            candy.setProducedDate(date);
        } catch (ParseException e) {
            throw new CustomParsingXMLException("Incorrect data format " + dateString + ".", e);
        }

        return candy;
    }

    private SimpleCandy buildSimpleCandy(Element candyElement) throws CustomParsingXMLException {
        SimpleCandy candy = (SimpleCandy) buildCandy(candyElement, CandyEnum.SIMPLE_CANDY);
        String type = candyElement.getAttribute(CandyEnum.TYPE.getTag());

        if (type != null && !type.isEmpty()) {
            candy.setType(SimpleCandyType.valueOf(type.toUpperCase()));
        }

        return candy;
    }

    private ChocolateCandy buildChocolateCandy(Element candyElement) throws CustomParsingXMLException {
        ChocolateCandy candy = (ChocolateCandy) buildCandy(candyElement, CandyEnum.CHOCOLATE_CANDY);
        String type = candyElement.getAttribute(CandyEnum.TYPE.getTag());

        candy.setType(ChocolateCandyType.valueOf(ChocolateCandyType.toEnumFormat(type)));
        candy.setChocolateType(getElementTextContext(candyElement, CandyEnum.CHOCOLATE_TYPE.getTag()));
        return candy;
    }

    private static String getElementTextContext(Element element, String elementName){
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }
}
