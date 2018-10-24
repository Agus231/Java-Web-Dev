package edu.epam.second.parser.impl;

import edu.epam.second.entity.impl.Symbol;
import edu.epam.second.entity.CharacterType;
import org.testng.annotations.DataProvider;

public class SymbolParserTestData {
    @DataProvider(name = "dataSymbolParser")
    public static Object[][] symbolParserTestData(){
        return new Object[][]{
                {'1', CharacterType.NUMBER, new Symbol('1', CharacterType.NUMBER)},
                {',', CharacterType.PUNCTUATION, new Symbol(',', CharacterType.PUNCTUATION)},
                {'a', CharacterType.LETTER, new Symbol('a', CharacterType.LETTER)}
        };
    }
}
