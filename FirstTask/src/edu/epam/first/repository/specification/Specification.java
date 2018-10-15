package edu.epam.first.repository.specification;

import java.util.function.Predicate;

public interface Specification<T> {
    Predicate<T> specified();
}
