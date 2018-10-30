package edu.epam.second.entity;

import java.util.List;

public interface TextComponent extends Cloneable{
    String operation();
    boolean add(TextComponent component);
    List<TextComponent> getComponents();
    ComponentType getComponentType();
    boolean remove(TextComponent component);
    TextComponent clone() throws CloneNotSupportedException;
}