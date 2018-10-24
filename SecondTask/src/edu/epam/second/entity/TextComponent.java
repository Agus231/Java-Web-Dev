package edu.epam.second.entity;

import edu.epam.second.entity.type.ComponentType;
import java.util.List;

//todo: question clone?
public interface TextComponent extends Cloneable{
    String operation();
    boolean add(TextComponent t);
    List<TextComponent> getComponents();
    ComponentType getComponentType();
    boolean remove(TextComponent t);
    TextComponent clone() throws CloneNotSupportedException;
}