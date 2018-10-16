package edu.epam.second.parser;

import edu.epam.second.entity.impl.ParagraphComposite;
import edu.epam.second.entity.impl.SentenceComposite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParagraphParser {
    //TODO: CHANGE REGEX
    private static final String PARAGRAPH_SPLIT_REGEX = "(?m)(?=^\\s{4})";
    private SentenceParser sentenceParser;

    public ParagraphParser(){
        sentenceParser = new SentenceParser();
    }

    public List<ParagraphComposite> parseParagraphs(String text){
        List<String> paragraphs = Arrays.stream(text.split(PARAGRAPH_SPLIT_REGEX))
                                        .collect(Collectors.toList());

        var paragraphComposites = new ArrayList<ParagraphComposite>();

        for (String paragraph: paragraphs) {
            var currentParagraph = new ParagraphComposite();

            List<SentenceComposite> sentenceComposites = sentenceParser.parseSentences(paragraph);
            sentenceComposites.forEach(currentParagraph::add);

            paragraphComposites.add(currentParagraph);
        }

        return paragraphComposites;
    }
}
