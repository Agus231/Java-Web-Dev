package edu.epam.second.entity.impl;

import edu.epam.second.entity.TextComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParagraphComposite implements TextComponent<SentenceComposite> {
    private List<SentenceComposite> sentences;

    public ParagraphComposite() {
        sentences = new ArrayList<>();
    }

    @Override
    public String operation() {
        return sentences.stream().map(SentenceComposite::operation).collect(Collectors.joining(" "));
    }

    @Override
    public boolean add(SentenceComposite sentence) {
        return sentences.add(sentence);
    }

    @Override
    public boolean remove(SentenceComposite sentence) {
        return sentences.remove(sentence);
    }
}
