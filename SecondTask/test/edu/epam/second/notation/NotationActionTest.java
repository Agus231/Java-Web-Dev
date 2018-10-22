package edu.epam.second.notation;

import edu.epam.second.parser.impl.ExpressionParser;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class NotationActionTest {
    private ExpressionParser expressionParser;
    private NotationAction notationAction;

    @BeforeClass
    public void setUp(){
        expressionParser = new ExpressionParser();
        notationAction = NotationAction.getInstance();
    }

    @Test(dataProvider = "dataNotationAction", dataProviderClass = NotationActionTestData.class)
    public void testCalculateExpression(String expression, Integer expected) {
        List<String> splitExpression = expressionParser.splitExpression(expression);
        Integer actual = notationAction.calculateExpression(splitExpression);
        Assert.assertEquals(actual, expected);
    }

    @AfterClass
    public void tearDown(){
        expressionParser = null;
    }
}