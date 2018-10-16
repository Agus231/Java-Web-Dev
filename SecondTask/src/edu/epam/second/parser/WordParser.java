package edu.epam.second.parser;

import edu.epam.second.entity.impl.WordComposite;

public class WordParser {
    private SymbolParser symbolParser;

    public WordParser(){
        symbolParser = new SymbolParser();
    }

    public WordComposite parseWord(String word){
        var wordComposite = new WordComposite();

        char[] letters = word.toCharArray();
        for (char letter: letters) {
            var wordComponent = symbolParser.parseSymbol(letter, );
            wordComposite.add(wordComponent);
        }
        return wordComposite;
    }
}
