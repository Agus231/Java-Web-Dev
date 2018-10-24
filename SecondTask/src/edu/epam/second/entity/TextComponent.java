package edu.epam.second.entity;

import java.util.List;

public interface TextComponent extends Cloneable{
    String operation();
    boolean add(TextComponent t);
    List<TextComponent> getComponents();
    ComponentType getComponentType();
    boolean remove(TextComponent t);
    TextComponent clone() throws CloneNotSupportedException;
}