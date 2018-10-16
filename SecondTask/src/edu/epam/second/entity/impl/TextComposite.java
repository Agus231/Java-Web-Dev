package edu.epam.second.entity.impl;

import edu.epam.second.entity.TextComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextComposite implements TextComponent<ParagraphComposite> {
    private List<ParagraphComposite> paragraphs;

    public TextComposite(){
        paragraphs = new ArrayList<>();
    }

    @Override
    public String operation() {
        return paragraphs.stream().map(ParagraphComposite::operation).collect(Collectors.joining("\n"));
    }

    @Override
    public boolean add(ParagraphComposite paragraph) {
        return paragraphs.add(paragraph);
    }

    @Override
    public boolean remove(ParagraphComposite paragraph) {
        return paragraphs.remove(paragraph);
    }
}
