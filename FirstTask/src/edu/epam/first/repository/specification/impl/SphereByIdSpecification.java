package edu.epam.first.repository.specification.impl;

import edu.epam.first.entity.Sphere;
import edu.epam.first.repository.specification.Specification;

import java.util.function.Predicate;

public class SphereByIdSpecification implements Specification<Sphere> {
    private long desiredId;

    public SphereByIdSpecification(long id){
        this.desiredId = id;
    }

    public void setDesiredId(long desiredId) {
        this.desiredId = desiredId;
    }

    public long getDesiredId() {
        return desiredId;
    }

    @Override
    public Predicate<Sphere> specified() {
        return (s) -> (s.getSphereId() == desiredId);
    }
}
