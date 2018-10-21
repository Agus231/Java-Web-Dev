package edu.epam.second.entity.impl;

import edu.epam.second.entity.type.ComponentType;
import edu.epam.second.entity.TextComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberComposite implements TextComponent<Symbol> {
    private static final ComponentType TYPE = ComponentType.NUMBER;
    private List<Symbol> numerics;

    public NumberComposite(){
        numerics = new ArrayList<>();
    }

    @Override
    public String operation() {
        return numerics.stream().map(Symbol::operation).collect(Collectors.joining());
    }

    @Override
    public boolean add(Symbol symbol) {
        return numerics.add(symbol);
    }

    @Override
    public boolean remove(Symbol symbol) {
        return numerics.remove(symbol);
    }
}
