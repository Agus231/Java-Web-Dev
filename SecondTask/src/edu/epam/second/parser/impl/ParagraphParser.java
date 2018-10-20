package edu.epam.second.parser.impl;

import edu.epam.second.entity.impl.ParagraphComposite;
import edu.epam.second.entity.impl.SentenceComposite;
import edu.epam.second.parser.BaseParser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParagraphParser implements BaseParser {
    private SentenceParser sentenceParser;

    public ParagraphParser(){
        sentenceParser = new SentenceParser();
    }

    @Override
    public ParagraphComposite parseTextPart(String paragraph){
        List<String> sentences = Arrays.stream(paragraph.split(SENTENCE_SPLIT_REGEX))
                                        .collect(Collectors.toList());

        var paragraphComposite = new ParagraphComposite();

        for (String sentence: sentences) {
            SentenceComposite sentenceComposite = sentenceParser.parseTextPart(sentence);
            paragraphComposite.add(sentenceComposite);
        }

        return paragraphComposite;
    }
}
