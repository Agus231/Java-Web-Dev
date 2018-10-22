package edu.epam.second.entity.impl;

import edu.epam.second.entity.type.ComponentType;
import edu.epam.second.entity.TextComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParagraphComposite implements TextComponent<SentenceComposite>, Cloneable {
    private static final ComponentType TYPE = ComponentType.PARAGRAPH;
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
    public List<SentenceComposite> getComponents() {
        return sentences;
    }

    @Override
    public ComponentType getComponentType() {
        return TYPE;
    }

    @Override
    public boolean remove(SentenceComposite sentence) {
        return sentences.remove(sentence);
    }

    @Override
    public ParagraphComposite clone() throws CloneNotSupportedException {
        ParagraphComposite paragraphComposite = (ParagraphComposite) super.clone();
        ArrayList<SentenceComposite> cloneList = new ArrayList<>();

        for (SentenceComposite sentence: sentences) {
            cloneList.add(sentence.clone());
        }

        paragraphComposite.sentences = cloneList;
        return paragraphComposite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParagraphComposite that = (ParagraphComposite) o;

        return sentences != null ? sentences.equals(that.sentences) : that.sentences == null;
    }

    @Override
    public int hashCode() {
        return sentences != null ? sentences.hashCode() : 0;
    }
}
