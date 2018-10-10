package edu.epam.first.repository;

import edu.epam.first.repository.specification.Specification;

import java.util.List;

public interface Repository<T> {
    void add(T t);
    void remove(T t);

    List<T> query(Specification<T> specification);
}
