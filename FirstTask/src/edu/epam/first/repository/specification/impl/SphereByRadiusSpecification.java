package edu.epam.first.repository.specification.impl;

import edu.epam.first.entity.Sphere;
import edu.epam.first.repository.specification.Specification;

import java.util.function.Predicate;

public class SphereByRadiusSpecification implements Specification<Sphere> {
    private double desiredRadius;

    public SphereByRadiusSpecification(double desiredRadius){
        this.desiredRadius = desiredRadius;
    }

    public void setDesiredRadius(double desiredRadius) {
        this.desiredRadius = desiredRadius;
    }

    public double getDesiredRadius() {
        return desiredRadius;
    }

    @Override
    public Predicate<Sphere> specified() {
        return (s) -> (s.getRadius() == desiredRadius);
    }
}
