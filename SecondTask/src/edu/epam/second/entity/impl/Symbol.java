package edu.epam.second.entity.impl;

import edu.epam.second.entity.type.ComponentType;
import edu.epam.second.entity.TextComponent;
import edu.epam.second.entity.type.CharacterType;

import java.util.List;

public class Symbol implements TextComponent, Cloneable {
    private static final ComponentType TYPE = ComponentType.SYMBOL;
    private Character value;
    private CharacterType type;

    public Symbol(char character, CharacterType type){
        this.value = character;
        this.type = type;
    }

    @Override
    public String operation() {
        return String.valueOf(value);
    }

    @Override
    public boolean add(TextComponent component) {
        throw new UnsupportedOperationException("Adding element to symbol is not supported.");
    }

    @Override
    public List<TextComponent> getComponents() {
        throw new UnsupportedOperationException("Symbol is a leaf element.");
    }

    @Override
    public ComponentType getComponentType() {
        return TYPE;
    }

    @Override
    public boolean remove(TextComponent component) {
        throw new UnsupportedOperationException("Removing element from symbol is not supported.");
    }

    @Override
    public Symbol clone() throws CloneNotSupportedException {
        return (Symbol) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symbol symbol = (Symbol) o;

        if (value != null ? !value.equals(symbol.value) : symbol.value != null) return false;
        return type == symbol.type;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
