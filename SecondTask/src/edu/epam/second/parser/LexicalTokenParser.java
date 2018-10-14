package edu.epam.second.parser;

import edu.epam.second.Component;
import edu.epam.second.entity.LexicalToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LexicalTokenParser {
    private static final String WORD_DELIMITER = "(?<=\\s)";
    private SymbolParser symbolParser = new SymbolParser();

    public List<LexicalToken> handleParse(String sentenceText){
        List<String> tokensTextList = Arrays.stream(sentenceText.split(WORD_DELIMITER))
                                            .filter(s -> !s.isEmpty())
                                            .collect(Collectors.toList());
        var tokens = new ArrayList<LexicalToken>();

        for (String token: tokensTextList) {
            List<Component> symbols = symbolParser.handleParse(token);
            var lexem = new LexicalToken();
            lexem.addAll(symbols);
            tokens.add(lexem);
        }

        return tokens;
    }
}
