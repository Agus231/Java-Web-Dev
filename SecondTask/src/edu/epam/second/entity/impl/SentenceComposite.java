package edu.epam.second.entity.impl;

import edu.epam.second.entity.type.ComponentType;
import edu.epam.second.entity.TextComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceComposite implements TextComponent<LexicalUnitComposite>, Cloneable {
    private static final ComponentType TYPE = ComponentType.SENTENCE;
    private List<LexicalUnitComposite> lexicalUnits;

    public SentenceComposite(){
        lexicalUnits = new ArrayList<>();
    }

    @Override
    public String operation() {
        return lexicalUnits.stream().map(TextComponent::operation).collect(Collectors.joining(" "));
    }

    @Override
    public boolean add(LexicalUnitComposite unit) {
        return lexicalUnits.add(unit);
    }

    @Override
    public List<LexicalUnitComposite> getComponents() {
        return lexicalUnits;
    }

    @Override
    public ComponentType getComponentType() {
        return TYPE;
    }

    @Override
    public boolean remove(LexicalUnitComposite unit) {
        return lexicalUnits.remove(unit);
    }

    @Override
    public SentenceComposite clone() throws CloneNotSupportedException {
        SentenceComposite sentenceComposite = (SentenceComposite) super.clone();
        ArrayList<LexicalUnitComposite> cloneList = new ArrayList<>();

        for (LexicalUnitComposite unit: lexicalUnits) {
            cloneList.add(unit.clone());
        }

        sentenceComposite.lexicalUnits = cloneList;
        return sentenceComposite;
    }
}
