package edu.epam.first.repository.specification;

public interface Specification<T> {
    boolean specified(T t);
}
