package edu.epam.second.entity.impl;

import edu.epam.second.entity.type.ComponentType;
import edu.epam.second.entity.TextComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LexicalUnitComposite implements TextComponent<TextComponent>, Cloneable {
    private static final ComponentType TYPE = ComponentType.LEXICALUNIT;
    private List<TextComponent> lexemParts;

    public LexicalUnitComposite(){
        lexemParts = new ArrayList<>();
    }

    @Override
    public String operation() {
        return lexemParts.stream().map(TextComponent::operation).collect(Collectors.joining());
    }

    @Override
    public boolean add(TextComponent component) {
        return lexemParts.add(component);
    }

    @Override
    public List<TextComponent> getComponents() {
        return lexemParts;
    }

    @Override
    public ComponentType getComponentType() {
        return TYPE;
    }

    @Override
    public boolean remove(TextComponent component) {
        return lexemParts.remove(component);
    }

    @Override
    public LexicalUnitComposite clone() throws CloneNotSupportedException {
        LexicalUnitComposite lexicalUnitComposite = (LexicalUnitComposite) super.clone();
        ArrayList<TextComponent> cloneList = new ArrayList<>();

        for (TextComponent part: lexemParts) {
            cloneList.add(part.clone());
        }

        lexicalUnitComposite.lexemParts = cloneList;
        return lexicalUnitComposite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LexicalUnitComposite that = (LexicalUnitComposite) o;

        return lexemParts != null ? lexemParts.equals(that.lexemParts) : that.lexemParts == null;
    }

    @Override
    public int hashCode() {
        return lexemParts != null ? lexemParts.hashCode() : 0;
    }
}

