package edu.epam.second.parser;

import edu.epam.second.entity.LexicalToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LexicalTokensParser {
    private static final String WORD_DELIMITER = "(?<=\\s)";
    private SymbolParser symbolParser = new SymbolParser();

    public List<LexicalToken> handleParse(String sentenceText){
        List<String> wordsTextList = new ArrayList<>(Arrays.asList(sentenceText.split(WORD_DELIMITER)));
        var tokens = new ArrayList<LexicalToken>();
        for (String wordText: wordsTextList) {
            tokens.add(new LexicalToken(wordText));
        }

        return tokens;
    }
}
