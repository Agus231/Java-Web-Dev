package edu.epam.first.repository;

public interface Specification<T> {
    boolean specified(T t);
}
