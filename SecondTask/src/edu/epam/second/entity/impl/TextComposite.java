package edu.epam.second.entity.impl;

import edu.epam.second.entity.type.ComponentType;
import edu.epam.second.entity.TextComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextComposite implements TextComponent<ParagraphComposite>, Cloneable {
    private static final ComponentType TYPE = ComponentType.TEXT;
    private List<ParagraphComposite> paragraphs;

    public TextComposite(){
        paragraphs = new ArrayList<>();
    }

    @Override
    public String operation() {
        return paragraphs.stream().map((s) -> "\t" + s.operation()).collect(Collectors.joining("\n"));
    }

    @Override
    public boolean add(ParagraphComposite paragraph) {
        return paragraphs.add(paragraph);
    }

    @Override
    public List<ParagraphComposite> getComponents() {
        return paragraphs;
    }

    @Override
    public ComponentType getComponentType() {
        return TYPE;
    }

    @Override
    public boolean remove(ParagraphComposite paragraph) {
        return paragraphs.remove(paragraph);
    }

    @Override
    public TextComposite clone() throws CloneNotSupportedException {
        TextComposite textComposite = (TextComposite) super.clone();
        ArrayList<ParagraphComposite> cloneList = new ArrayList<>();

        for (ParagraphComposite paragraph: paragraphs) {
            cloneList.add(paragraph.clone());
        }

        textComposite.paragraphs = cloneList;
        return textComposite;
    }
}
