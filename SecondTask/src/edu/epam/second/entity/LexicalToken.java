package edu.epam.second.entity;

import edu.epam.second.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LexicalToken implements Component<Component> {
    private List<Component> symbols = new ArrayList<>();

    @Override
    public void operation() {
        symbols.forEach(Component::operation);
    }

    @Override
    public boolean add(Component component) {
        return symbols.add(component);
    }

    @Override
    public boolean addAll(List<Component> component) {
        return symbols.addAll(component);
    }

    @Override
    public boolean remove(Component component) {
        return symbols.remove(component);
    }

    public Word getWordFromLexem(){
        Word word = null;
        for (Component c: symbols) {
            if (c instanceof Word)
                word = (Word) c;
        }
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LexicalToken that = (LexicalToken) o;
        return Objects.equals(symbols, that.symbols);
    }

    @Override
    public String toString() {
        return "LexicalToken{" +
                "symbols=" + symbols +
                '}';
    }

    @Override
    public int hashCode() {

        return Objects.hash(symbols);
    }
}
