package edu.epam.second.parser.impl;

import edu.epam.second.entity.TextComponent;
import edu.epam.second.entity.impl.Symbol;
import edu.epam.second.entity.impl.TextComposite;
import edu.epam.second.entity.type.CharacterType;
import edu.epam.second.entity.type.ComponentType;
import org.testng.annotations.DataProvider;

public class ExpressionParserTestData {
    @DataProvider(name = "expressionParserData")
    public static Object[][] expressionParserData(){
        TextComponent firstExpressionResult = new TextComposite(ComponentType.NUMBER);
        firstExpressionResult.add(new Symbol('5', CharacterType.NUMBER));
        firstExpressionResult.add(new Symbol('2', CharacterType.NUMBER));

        TextComponent secondAndThirdResult = new TextComposite(ComponentType.NUMBER);
        secondAndThirdResult.add(new Symbol('0', CharacterType.NUMBER));

        TextComponent fourthExpressionResult = new TextComposite(ComponentType.NUMBER);
        fourthExpressionResult.add(new Symbol('5', CharacterType.NUMBER));

        TextComponent fiveExpressionResult = new TextComposite(ComponentType.NUMBER);
        fiveExpressionResult.add(new Symbol('7', CharacterType.NUMBER));
        fiveExpressionResult.add(new Symbol('9', CharacterType.NUMBER));

        TextComponent sixExpressionResult = new TextComposite(ComponentType.NUMBER);
        sixExpressionResult.add(new Symbol('1', CharacterType.NUMBER));
        sixExpressionResult.add(new Symbol('2', CharacterType.NUMBER));
        sixExpressionResult.add(new Symbol('1', CharacterType.NUMBER));
        sixExpressionResult.add(new Symbol('3', CharacterType.NUMBER));

        return new Object[][]{
                {"13<<2", firstExpressionResult},
                {"3>>5", secondAndThirdResult},
                {"6&9|(3&4)", secondAndThirdResult},
                {"5|(1&2&(3|(4&(2^5|6&47)|3)|2)|1)", fourthExpressionResult},
                {"(71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78", fiveExpressionResult},
                {"(8^5|1&2<<(2|5>>2&71))|1200", sixExpressionResult}
        };
    }
}
