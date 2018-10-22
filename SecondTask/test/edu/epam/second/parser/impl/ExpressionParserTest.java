package edu.epam.second.parser.impl;

import edu.epam.second.entity.impl.NumberComposite;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ExpressionParserTest {
    private ExpressionParser expressionParser;

    @BeforeClass
    public void setUp(){
        expressionParser = new ExpressionParser();
    }

    @Test(dataProviderClass = ExpressionParserTestData.class, dataProvider = "expressionParserData")
    public void testParseTextPart(String expression, NumberComposite expected) {
        NumberComposite actual = expressionParser.parseTextPart(expression);
        Assert.assertEquals(actual, expected);
    }

    @AfterClass
    public void tearDown(){
        expressionParser = null;
    }
}