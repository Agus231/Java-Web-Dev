package edu.epam.second.parser.impl;

import edu.epam.second.entity.impl.Symbol;
import edu.epam.second.entity.type.CharacterType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SymbolParserTest {
    private SymbolParser symbolParser;

    @BeforeClass
    public void setUp(){
        symbolParser = new SymbolParser();
    }

    @Test(dataProviderClass = SymbolParserTestData.class, dataProvider = "dataSymbolParser")
    public void testParseTextPart(Character character, CharacterType type, Symbol symbol) {
        Assert.assertEquals(new Symbol(character, type), symbol);
    }

    @AfterClass
    public void tearDown(){
        symbolParser = null;
    }
}