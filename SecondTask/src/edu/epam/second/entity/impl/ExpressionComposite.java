package edu.epam.second.entity.impl;

import edu.epam.second.entity.type.ComponentType;
import edu.epam.second.entity.TextComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressionComposite implements TextComponent<Symbol> {
    private static final ComponentType TYPE = ComponentType.EXPRESSION;
    private List<Symbol> expressionSymbols;

    public ExpressionComposite(){
        expressionSymbols = new ArrayList<>();
    }

    @Override
    public String operation() {
        return expressionSymbols.stream().map(Symbol::operation).collect(Collectors.joining());
    }

    @Override
    public boolean add(Symbol symbol) {
        return expressionSymbols.add(symbol);
    }

    @Override
    public boolean remove(Symbol symbol) {
        return expressionSymbols.remove(symbol);
    }
}
