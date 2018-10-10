package edu.epam.first.repository.specification.impl;

import edu.epam.first.entity.Sphere;
import edu.epam.first.repository.specification.Specification;

public class SphereRadiusBetweenSpecification implements Specification<Sphere> {
    private double minRadius;
    private double maxRadius;

    public SphereRadiusBetweenSpecification(double min, double max){
        this.minRadius = min;
        this.maxRadius = max;
    }

    public double getMaxRadius() {
        return maxRadius;
    }

    public double getMinRadius() {
        return minRadius;
    }

    public void setMaxRadius(double maxRadius) {
        this.maxRadius = maxRadius;
    }

    public void setMinRadius(double minRadius) {
        this.minRadius = minRadius;
    }

    @Override
    public boolean specified(Sphere sphere) {
        return (sphere.getRadius() >= minRadius && sphere.getRadius() < maxRadius);
    }
}
