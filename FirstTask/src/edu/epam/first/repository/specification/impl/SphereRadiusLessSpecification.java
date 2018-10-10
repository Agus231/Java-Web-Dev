package edu.epam.first.repository.specification.impl;

import edu.epam.first.entity.Sphere;
import edu.epam.first.repository.specification.Specification;

public class SphereRadiusLessSpecification implements Specification<Sphere> {
    private double maxRadius;

    public SphereRadiusLessSpecification(double maxRadius){
        this.maxRadius = maxRadius;
    }

    public double getMaxRadius() {
        return maxRadius;
    }

    public void setMaxRadius(double maxRadius) {
        this.maxRadius = maxRadius;
    }

    @Override
    public boolean specified(Sphere sphere) {
        return (sphere.getRadius() < maxRadius);
    }
}
