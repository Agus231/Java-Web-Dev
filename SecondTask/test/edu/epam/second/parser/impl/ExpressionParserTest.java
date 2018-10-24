package edu.epam.second.parser.impl;

import edu.epam.second.entity.TextComponent;
import edu.epam.second.entity.impl.TextComposite;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExpressionParserTest {
    private ExpressionParser expressionParser;

    @BeforeClass
    public void setUp(){
        expressionParser = new ExpressionParser();
    }

    @Test(dataProviderClass = ExpressionParserTestData.class, dataProvider = "expressionParserData")
    public void testParseTextPart(String expression, TextComponent expected) {
        TextComponent actual = expressionParser.parseTextPart(expression);
        Assert.assertEquals(actual, expected);
    }

    @AfterClass
    public void tearDown(){
        expressionParser = null;
    }
}