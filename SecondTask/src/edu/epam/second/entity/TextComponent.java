package edu.epam.second.entity;

import edu.epam.second.entity.type.ComponentType;
import java.util.List;

//todo: question clone?
public interface TextComponent<T extends TextComponent> extends Cloneable{
    String operation();
    boolean add(T t);
    List<T> getComponents();
    ComponentType getComponentType();
    boolean remove(T t);
    TextComponent clone() throws CloneNotSupportedException;
}
