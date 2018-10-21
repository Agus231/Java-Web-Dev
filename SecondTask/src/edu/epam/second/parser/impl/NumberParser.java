package edu.epam.second.parser.impl;

import edu.epam.second.entity.impl.NumberComposite;
import edu.epam.second.entity.type.CharacterType;
import edu.epam.second.parser.BaseParser;

public class NumberParser implements BaseParser {
    private SymbolParser symbolParser;

    public NumberParser(){
        symbolParser = new SymbolParser();
    }

    @Override
    public NumberComposite parseTextPart(String number) {
        var numberComposite = new NumberComposite();

        char[] digits = number.toCharArray();
        for (char digit: digits) {
            var numberComponent = symbolParser.parseTextPart(String.valueOf(digit), CharacterType.NUMBER);
            numberComposite.add(numberComponent);
        }
        return numberComposite;
    }
}
