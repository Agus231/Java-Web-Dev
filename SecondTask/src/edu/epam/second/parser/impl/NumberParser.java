package edu.epam.second.parser.impl;

import edu.epam.second.entity.TextComponent;
import edu.epam.second.entity.impl.TextComposite;
import edu.epam.second.entity.CharacterType;
import edu.epam.second.entity.ComponentType;
import edu.epam.second.parser.BaseParser;

public class NumberParser implements BaseParser {
    private SymbolParser symbolParser;

    public NumberParser(){
        symbolParser = new SymbolParser();
    }

    @Override
    public TextComponent parseTextPart(String number) {
        var numberComposite = new TextComposite(ComponentType.NUMBER);

        char[] digits = number.toCharArray();
        for (char digit: digits) {
            var numberComponent = symbolParser.parseTextPart(String.valueOf(digit), CharacterType.NUMBER);
            numberComposite.add(numberComponent);
        }
        return numberComposite;
    }
}
