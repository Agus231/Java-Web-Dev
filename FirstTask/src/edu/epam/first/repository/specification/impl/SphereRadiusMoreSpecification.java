package edu.epam.first.repository.specification.impl;

import edu.epam.first.entity.Sphere;
import edu.epam.first.repository.specification.Specification;

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
    public boolean specified(Sphere sphere) {
        return (sphere.getRadius() > minRadius);
    }
}
