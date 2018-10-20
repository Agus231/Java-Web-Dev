package edu.epam.second.parser.impl;

import edu.epam.second.entity.impl.WordComposite;
import edu.epam.second.entity.type.CharacterType;
import edu.epam.second.parser.BaseParser;

public class WordParser implements BaseParser {
    private SymbolParser symbolParser;

    public WordParser(){
        symbolParser = new SymbolParser();
    }

    @Override
    public WordComposite parseTextPart(String word){
        var wordComposite = new WordComposite();

        char[] letters = word.toCharArray();
        for (char letter: letters) {
            var wordComponent = symbolParser.parseTextPart(String.valueOf(letter), CharacterType.LETTER);
            wordComposite.add(wordComponent);
        }
        return wordComposite;
    }
}
