package edu.epam.second.parser;

import edu.epam.second.entity.Paragraph;
import edu.epam.second.entity.Sentence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParagraphParser {
    private static final String PARAGRAPH_DELIMITER = "(\\s{4,5}|\\t)";
    private SentenceParser sentenceParser = new SentenceParser();

    public List<Paragraph> handleParse(String text){
        List<String> paragraphSentencesList = Arrays.stream(text.split(PARAGRAPH_DELIMITER))
                                                    .filter(s -> !s.isEmpty())
                                                    .collect(Collectors.toList());

        var paragraphs = new ArrayList<Paragraph>();

        for (String paragraphText: paragraphSentencesList) {
            List<Sentence> sentences = sentenceParser.handleParse(paragraphText);
            var paragraph = new Paragraph();
            paragraph.addAll(sentences);
            paragraphs.add(paragraph);
        }

        return paragraphs;
    }
}
