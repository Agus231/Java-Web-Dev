package edu.epam.second.parser.impl;

import edu.epam.second.entity.TextComponent;
import edu.epam.second.entity.impl.TextComposite;
import edu.epam.second.entity.ComponentType;
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
    public TextComponent parseTextPart(String paragraph){
        List<String> sentences = Arrays.stream(paragraph.split(SENTENCE_SPLIT_REGEX))
                                        .collect(Collectors.toList());

        var paragraphComposite = new TextComposite(ComponentType.PARAGRAPH);

        for (String sentence: sentences) {
            TextComponent sentenceComposite = sentenceParser.parseTextPart(sentence.trim());
            paragraphComposite.add(sentenceComposite);
        }

        return paragraphComposite;
    }
}
