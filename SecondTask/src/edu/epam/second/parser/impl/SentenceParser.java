package edu.epam.second.parser.impl;

import edu.epam.second.entity.impl.LexicalUnitComposite;
import edu.epam.second.entity.impl.SentenceComposite;
import edu.epam.second.parser.BaseParser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceParser implements BaseParser {
    private LexicalUnitParser unitParser;

    public SentenceParser(){
        unitParser = new LexicalUnitParser();
    }

    @Override
    public SentenceComposite parseTextPart(String sentence){
        List<String> units = Arrays.stream(sentence.split(LEXICAL_UNIT_SPLIT_REGEX))
                                    .collect(Collectors.toList());

        var sentenceComposite = new SentenceComposite();

        for (String unit: units) {
            LexicalUnitComposite lexicalUnitComposite = unitParser.parseTextPart(unit.trim());
            sentenceComposite.add(lexicalUnitComposite);
        }

        return sentenceComposite;
    }
}