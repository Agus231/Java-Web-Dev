package edu.epam.second.entity.impl;

import edu.epam.second.entity.type.ComponentType;
import edu.epam.second.entity.TextComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberComposite implements TextComponent<Symbol>, Cloneable {
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
    public List<Symbol> getComponents() {
        return numerics;
    }

    @Override
    public ComponentType getComponentType() {
        return TYPE;
    }

    @Override
    public boolean remove(Symbol symbol) {
        return numerics.remove(symbol);
    }

    @Override
    public NumberComposite clone() throws CloneNotSupportedException {
        NumberComposite numberComposite = (NumberComposite) super.clone();
        ArrayList<Symbol> cloneList = new ArrayList<>();

        for (Symbol symbol: numerics) {
            cloneList.add(symbol.clone());
        }

        numberComposite.numerics = cloneList;
        return numberComposite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NumberComposite that = (NumberComposite) o;

        return numerics != null ? numerics.equals(that.numerics) : that.numerics == null;
    }

    @Override
    public int hashCode() {
        return numerics != null ? numerics.hashCode() : 0;
    }
}
