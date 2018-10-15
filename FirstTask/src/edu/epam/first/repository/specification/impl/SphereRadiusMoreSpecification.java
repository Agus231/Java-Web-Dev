package edu.epam.first.repository.specification.impl;

import edu.epam.first.entity.Sphere;
import edu.epam.first.repository.specification.Specification;

import java.util.function.Predicate;

public class SphereRadiusMoreSpecification implements Specification<Sphere> {
    private double minRadius;

    public SphereRadiusMoreSpecification(double minRadius){
        this.minRadius = minRadius;
    }

    public double getMinRadius() {
        return minRadius;
    }

    public void setMinRadius(double minRadius) {
        this.minRadius = minRadius;
    }

    @Override
    public Predicate<Sphere> specified() {
        return (s) -> (s.getRadius() > minRadius);
    }
}
