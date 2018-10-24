package edu.epam.second.parser.impl;

import edu.epam.second.entity.impl.Symbol;
import edu.epam.second.entity.CharacterType;
import edu.epam.second.parser.BaseParser;

public class SymbolParser implements BaseParser {
    public Symbol parseTextPart(String value, CharacterType type){
        return new Symbol(value.charAt(0), type);
    }

    @Override
    public Symbol parseTextPart(String value){
        CharacterType type;
        char charValue = value.charAt(0);
        if (Character.isLetter(charValue)){
            type = CharacterType.LETTER;
        } else if(Character.isDigit(charValue)){
            type = CharacterType.NUMBER;
        } else{
            type = CharacterType.PUNCTUATION;
        }

        return parseTextPart(value, type);
    }
}
