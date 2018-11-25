package edu.epam.xml.model.parser.sax;

import edu.epam.xml.model.entity.Candy;
import edu.epam.xml.model.entity.CandyEnum;
import edu.epam.xml.model.entity.ChocolateCandy;
import edu.epam.xml.model.entity.SimpleCandy;
import edu.epam.xml.model.util.DateXMLFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import static edu.epam.xml.model.entity.SimpleCandy.SimpleCandyType;
import static edu.epam.xml.model.entity.ChocolateCandy.ChocolateCandyType;

public class CandyHandler extends DefaultHandler {
    private Set<Candy> candies;

    private static Logger logger = LogManager.getLogger();

    private Candy current;
    private CandyEnum currentEnum;

    private EnumSet<CandyEnum> ingredients;
    private EnumSet<CandyEnum> values;
    private EnumSet<CandyEnum> elements;

    public CandyHandler(){
        candies = new HashSet<>();
        ingredients = EnumSet.range(CandyEnum.WATER, CandyEnum.VANILLA);
        values = EnumSet.range(CandyEnum.PROTEINS, CandyEnum.STARCHES);
        elements = EnumSet.range(CandyEnum.NAME, CandyEnum.PRODUCED_DATE);
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        String enumName = CandyEnum.toEnumFormat(qName);
        CandyEnum candyEnum = CandyEnum.valueOf(enumName);

        switch (candyEnum) {
            case SIMPLE_CANDY:
                current = new SimpleCandy();
                current.setCandyId(attributes.getValue(CandyEnum.ID.getTag()));

                String simpleTypeName = attributes.getValue(CandyEnum.TYPE.getTag());

                if (simpleTypeName != null) {
                    SimpleCandyType simpleType = SimpleCandyType.valueOf(simpleTypeName.toUpperCase());
                    current.setType(simpleType);
                }
                break;
            case CHOCOLATE_CANDY:
                current = new ChocolateCandy();
                current.setCandyId(attributes.getValue(CandyEnum.ID.getTag()));

                String complexTypeName = attributes.getValue(CandyEnum.TYPE.getTag());

                if (complexTypeName != null) {
                    ChocolateCandyType complexType = ChocolateCandyType.valueOf(ChocolateCandyType.toEnumFormat(complexTypeName));
                    current.setType(complexType);
                }
                break;
                default:
                    currentEnum = candyEnum;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (CandyEnum.SIMPLE_CANDY.getTag().equals(qName) || CandyEnum.CHOCOLATE_CANDY.getTag().equals(qName)) {
            candies.add(current);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length);

        if(currentEnum != null){
            if (ingredients.contains(currentEnum)) {
                switch (currentEnum) {
                    case SUGAR:
                        current.getIngredients().setSugar(Integer.parseInt(s));
                        break;
                    case WATER:
                        current.getIngredients().setWater(Integer.parseInt(s));
                        break;
                    case FRUCTOSE:
                        current.getIngredients().setFructose(Integer.parseInt(s));
                        break;
                    case VANILLA:
                        current.getIngredients().setVanilla(Integer.parseInt(s));
                        break;
                }
            }
            else if (values.contains(currentEnum)){
                switch (currentEnum) {
                    case FATS:
                        current.getValues().setFats(Integer.parseInt(s));
                        break;
                    case PROTEINS:
                        current.getValues().setProteins(Integer.parseInt(s));
                        break;
                    case STARCHES:
                        current.getValues().setStarches(Integer.parseInt(s));
                        break;
                }
            }
            else if (elements.contains(currentEnum)){
                switch (currentEnum) {
                    case NAME:
                        current.setName(s);
                        break;
                    case ENERGY:
                        current.setEnergy(Integer.parseInt(s));
                        break;
                    case PRODUCTION:
                        current.setProduction(s);
                        break;
                    case PRODUCED_DATE:
                        try {
                            Date date = DateXMLFilter.parseDate(s);
                            current.setProducedDate(date);
                        } catch (ParseException e) {
                            logger.error(e.getMessage(), e);
                        }
                        break;
                    case CHOCOLATE_TYPE:
                        ((ChocolateCandy) current).setChocolateType(s);
                        break;
                }
            }
        }
        currentEnum = null;
    }
}
