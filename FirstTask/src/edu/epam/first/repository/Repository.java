package edu.epam.first.repository;

import edu.epam.first.repository.specification.Specification;

import java.util.Comparator;
import java.util.List;

public interface Repository<T> {
    void add(T t);
    List<T> sort(Comparator<T> comparator);
    List<T> query(Specification<T> specification);
}
