package edu.epam.second.entity.impl;

import edu.epam.second.entity.type.ComponentType;
import edu.epam.second.entity.TextComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WordComposite implements TextComponent<Symbol>, Cloneable {
    private static final ComponentType TYPE = ComponentType.WORD;
    private ArrayList<Symbol> wordSymbols;

    public WordComposite(){
        wordSymbols = new ArrayList<>();
    }

    @Override
    public String operation() {
        return wordSymbols.stream().map(Symbol::operation).collect(Collectors.joining());
    }

    @Override
    public boolean add(Symbol symbol) {
        return wordSymbols.add(symbol);
    }

    @Override
    public List<Symbol> getComponents() {
        return wordSymbols;
    }

    @Override
    public ComponentType getComponentType() {
        return TYPE;
    }

    @Override
    public boolean remove(Symbol symbol) {
        return wordSymbols.remove(symbol);
    }

    @Override
    public WordComposite clone() throws CloneNotSupportedException {
        WordComposite wordComposite = (WordComposite) super.clone();
        ArrayList<Symbol> cloneList = new ArrayList<>();

        for (Symbol symbol: wordSymbols) {
            cloneList.add(symbol.clone());
        }

        wordComposite.wordSymbols = cloneList;
        return wordComposite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordComposite that = (WordComposite) o;

        return wordSymbols != null ? wordSymbols.equals(that.wordSymbols) : that.wordSymbols == null;
    }

    @Override
    public int hashCode() {
        return wordSymbols != null ? wordSymbols.hashCode() : 0;
    }
}
