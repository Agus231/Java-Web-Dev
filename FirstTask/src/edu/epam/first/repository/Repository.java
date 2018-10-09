package edu.epam.first.repository;

import java.util.List;

public interface Repository<T> {
    void add(T t);
    void remove(T t);

    List<T> query(Specification<T> specification);
}
