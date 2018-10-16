package edu.epam.second.parser;

import edu.epam.second.entity.impl.Symbol;
import edu.epam.second.entity.type.CharacterType;

public class SymbolParser {
    public Symbol parseSymbol(char value, CharacterType type){
        return new Symbol(value, type);
    }

    public Symbol parseSymbol(char value){
        CharacterType type;
        if (Character.isLetter(value)){
            type = CharacterType.LETTER;
        } else if(Character.isDigit(value)){
            type = CharacterType.NUMBER;
        } else{
            type = CharacterType.PUNCTUATION;
        }

        return parseSymbol(value, type);
    }
}
