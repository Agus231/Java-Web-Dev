package edu.epam.first.repository.specification;

import java.util.function.Predicate;

//todo: change to predicate
public interface Specification<T> {
    Predicate<T> specified();
}
