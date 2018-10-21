package edu.epam.second.entity.impl;

import edu.epam.second.entity.type.ComponentType;
import edu.epam.second.entity.TextComponent;
import edu.epam.second.entity.type.CharacterType;

public class Symbol implements TextComponent {
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
    public boolean remove(TextComponent component) {
        throw new UnsupportedOperationException("Removing element from symbol is not supported.");
    }
}
