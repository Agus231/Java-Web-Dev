package edu.epam.second.parser;

import edu.epam.second.entity.TextComponent;
import edu.epam.second.entity.impl.SentenceComposite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceParser {
    private static final String SENTENCE_SPLIT_REGEX = "(?<=[.!?\\u2026])";
    private LexicalUnitParser unitParser;

    public SentenceParser(){
        unitParser = new LexicalUnitParser();
    }

    public List<SentenceComposite> parseSentences(String text){
        List<String> sentences = Arrays.stream(text.split(SENTENCE_SPLIT_REGEX))
                                        .collect(Collectors.toList());

        var sentenceComposites = new ArrayList<SentenceComposite>();

        //todo: can throw exception
        for (String sentence: sentences) {
            TextComponent currentSentence = new SentenceComposite();

            List<TextComponent> unitComposites = unitParser.parseUnits(sentence);
            unitComposites.forEach(currentSentence::add);

            sentenceComposites.add((SentenceComposite) currentSentence);
        }

        return sentenceComposites;
    }
}
