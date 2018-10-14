package edu.epam.second;

public interface Composite {
    void operation();
    boolean add(Composite composite);
    boolean remove(Composite composite);
}
