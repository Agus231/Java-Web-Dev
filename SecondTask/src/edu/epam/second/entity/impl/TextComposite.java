package edu.epam.second.entity.impl;

import edu.epam.second.entity.ComponentType;
import edu.epam.second.entity.TextComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextComposite implements TextComponent, Cloneable {
    private ComponentType TYPE;
    private List<TextComponent> textComponents;

    private final String NEW_LINE_REGEX = "\n";
    private final String TABULATION_REGEX = "\t";

    public TextComposite(ComponentType type){
        this.TYPE = type;
        textComponents = new ArrayList<>();
    }

    @Override
    public String operation() {
        String resultString = null;
        switch (TYPE) {
            case NUMBER:
                resultString = textComponents.stream().map(TextComponent::operation).collect(Collectors.joining());
                break;
            case WORD:
                resultString = textComponents.stream().map(TextComponent::operation).collect(Collectors.joining());
                break;
            case LEXICALUNIT:
                resultString = textComponents.stream().map(TextComponent::operation).collect(Collectors.joining());
                break;
            case SENTENCE:
                resultString = textComponents.stream().map(TextComponent::operation).collect(Collectors.joining(" "));
                break;
            case PARAGRAPH:
                resultString = textComponents.stream().map(TextComponent::operation).collect(Collectors.joining(" "));
                break;
            case TEXT:
                resultString = textComponents.stream().map((s) -> TABULATION_REGEX + s.operation()).collect(Collectors.joining(NEW_LINE_REGEX));
                break;
        }
        return resultString;
    }

    @Override
    public boolean add(TextComponent component) {
        return textComponents.add(component);
    }

    @Override
    public List<TextComponent> getComponents() {
        return textComponents;
    }

    @Override
    public ComponentType getComponentType() {
        return TYPE;
    }

    @Override
    public boolean remove(TextComponent component) {
        return textComponents.remove(component);
    }

    @Override
    public TextComposite clone() throws CloneNotSupportedException {
        TextComposite textComposite = (TextComposite) super.clone();
        ArrayList<TextComponent> cloneList = new ArrayList<>();

        for (TextComponent textComponent: textComponents) {
            cloneList.add(textComponent.clone());
        }

        textComposite.textComponents = cloneList;
        return textComposite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextComposite that = (TextComposite) o;

        return textComponents != null ? textComponents.equals(that.textComponents) : that.textComponents == null;
    }

    @Override
    public int hashCode() {
        return textComponents != null ? textComponents.hashCode() : 0;
    }
}
