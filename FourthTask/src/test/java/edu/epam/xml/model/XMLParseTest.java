package edu.epam.xml.model;

import edu.epam.xml.model.entity.Candy;
import edu.epam.xml.model.exception.CustomParsingXMLException;
import edu.epam.xml.model.parser.AbstractCandyBuilder;
import edu.epam.xml.model.parser.CandyBuilderFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.Set;

public class XMLParseTest {
    private CandyBuilderFactory candyFactory;

    @BeforeClass
    public void setUp(){
        candyFactory = new CandyBuilderFactory();
    }

    @Test(dataProvider = "dataParsedCount", dataProviderClass = XMLParseTestData.class)
    public void testCount(String parserName, int expected) throws CustomParsingXMLException {
        InputStream is = getClass().getResourceAsStream("/test.xml");
        AbstractCandyBuilder builder = candyFactory.createCandyBuilder(parserName);
        builder.buildSetCandies(is);
        Set<Candy> candies = builder.getCandies();

        Assert.assertEquals(candies.size(), expected);
    }

    @Test(dataProvider = "dataParsedEquality", dataProviderClass = XMLParseTestData.class)
    public void testCount(String parserName, Set expected) throws CustomParsingXMLException {
        InputStream is = getClass().getResourceAsStream("/test.xml");
        AbstractCandyBuilder builder = candyFactory.createCandyBuilder(parserName);
        builder.buildSetCandies(is);
        Set<Candy> candies = builder.getCandies();

        Assert.assertEquals(candies.toString(), expected.toString());
    }

    @AfterClass
    public void tearDown(){
        candyFactory = null;
    }
}
