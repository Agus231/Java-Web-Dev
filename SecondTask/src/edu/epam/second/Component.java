package edu.epam.second;

import java.util.List;

public interface Component<T extends Component> {
    void operation();
    boolean add(T component);
    boolean addAll(List<T> component);
    boolean remove(T component);
}
