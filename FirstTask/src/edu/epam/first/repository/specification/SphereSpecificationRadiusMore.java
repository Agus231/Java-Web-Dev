package edu.epam.first.repository.specification;

import edu.epam.first.entity.Sphere;
import edu.epam.first.repository.Specification;

public class SphereSpecificationRadiusMore implements Specification<Sphere> {
    private double minRadius;

    public SphereSpecificationRadiusMore(double minRadius){
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
