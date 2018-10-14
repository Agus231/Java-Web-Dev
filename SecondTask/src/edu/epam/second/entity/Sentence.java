package edu.epam.second.entity;

import edu.epam.second.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sentence implements Component<LexicalToken> {
    private List<LexicalToken> tokens = new ArrayList<>();

    @Override
    public void operation() {
        tokens.forEach(Component::operation);
    }

    @Override
    public boolean add(LexicalToken component) {
        return tokens.add(component);
    }

    @Override
    public boolean addAll(List<LexicalToken> component) {
        return tokens.addAll(component);
    }

    @Override
    public boolean remove(LexicalToken component) {
        return tokens.remove(component);
    }

    public List<LexicalToken> getTokens() {
        return tokens;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "tokens=" + tokens +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }

        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Sentence sentence = (Sentence) o;
        return Objects.equals(tokens, sentence.tokens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tokens);
    }
}
