package edu.epam.second.entity;

public interface TextComponent<T extends TextComponent> {
    String operation();
    boolean add(T t);
    boolean remove(T t);
}
