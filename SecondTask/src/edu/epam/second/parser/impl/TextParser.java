package edu.epam.second.parser.impl;

import edu.epam.second.entity.impl.ParagraphComposite;
import edu.epam.second.entity.impl.TextComposite;
import edu.epam.second.parser.BaseParser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextParser implements BaseParser {
    private ParagraphParser paragraphParser;

    public TextParser(){
        paragraphParser = new ParagraphParser();
    }

    @Override
    public TextComposite parseTextPart(String text){
        List<String> paragraphs = Arrays.stream(text.split(PARAGRAPH_SPLIT_REGEX))
                                        .collect(Collectors.toList());

        var textComposite = new TextComposite();

        for (String paragraph: paragraphs) {
            ParagraphComposite paragraphComposite = paragraphParser.parseTextPart(paragraph.trim());
            textComposite.add(paragraphComposite);
        }

        return textComposite;
    }
}
