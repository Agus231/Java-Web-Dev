package edu.epam.second.parser.impl;

import edu.epam.second.entity.TextComponent;
import edu.epam.second.entity.impl.TextComposite;
import edu.epam.second.entity.type.ComponentType;
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
    public TextComponent parseTextPart(String sentence){
        List<String> units = Arrays.stream(sentence.split(LEXICAL_UNIT_SPLIT_REGEX))
                                    .collect(Collectors.toList());

        var sentenceComposite = new TextComposite(ComponentType.SENTENCE);

        for (String unit: units) {
            TextComponent lexicalUnitComposite = unitParser.parseTextPart(unit.trim());
            sentenceComposite.add(lexicalUnitComposite);
        }

        return sentenceComposite;
    }
}