package edu.epam.second.action;

import edu.epam.second.entity.impl.TextComposite;
import edu.epam.second.exception.TextException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TextActionTest {
    private TextAction action;

    @BeforeClass
    public void setUp(){
        action = TextAction.getInstance();
    }


    @Test(dataProvider = "dataTextActionSortParagraphs", dataProviderClass = TextActionTestData.class)
    public void testSortParagraphs(TextComposite input, TextComposite expected) throws TextException {
        TextComposite actual = action.sortParagraphs(input);
        Assert.assertEquals(actual.operation(), expected.operation());
    }

    @Test(dataProvider = "dataTextActionSortWords", dataProviderClass = TextActionTestData.class)
    public void testSortWords(TextComposite input, TextComposite expected) throws TextException {
        TextComposite actual = action.sortWords(input);
        Assert.assertEquals(actual.operation(), expected.operation());
    }

    @Test(dataProvider = "dataTextActionSortLexicalUnits", dataProviderClass = TextActionTestData.class)
    public void testSortLexicalUnits(TextComposite input, TextComposite expected) throws TextException {
        TextComposite actual = action.sortLexicalUnits(input, 'e');
        Assert.assertEquals(actual.operation(), expected.operation());
    }

    @AfterClass
    public void tearDown(){
        action = null;
    }
}