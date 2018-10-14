package edu.epam.second.parser;

import edu.epam.second.entity.Sentence;
import edu.epam.second.entity.LexicalToken;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceParser {
    private static final String SENTENCE_DELIMITERS = "(?<=[\\.!\\?])";
    private LexicalTokenParser lexicalTokenParser = new LexicalTokenParser();

    public List<Sentence> handleParse(String paragraphText){
        List<String> sentencesTextList = Arrays.stream(paragraphText.split(SENTENCE_DELIMITERS))
                                                                    .filter(s -> !s.isEmpty())
                                                                    .collect(Collectors.toList());
        var sentences = new ArrayList<Sentence>();

        for (String sentenceText: sentencesTextList) {
            List<LexicalToken> lexicalTokens = lexicalTokenParser.handleParse(sentenceText);
            var sentence = new Sentence();
            sentence.addAll(lexicalTokens);
            sentences.add(sentence);
        }

        return sentences;
    }
}
