package edu.epam.second.entity.impl;

import edu.epam.second.entity.type.ComponentType;
import edu.epam.second.entity.TextComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WordComposite implements TextComponent<Symbol> {
    public static final ComponentType TYPE = ComponentType.WORD;
    private List<Symbol> wordSymbols;

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
    public boolean remove(Symbol symbol) {
        return wordSymbols.remove(symbol);
    }
}
