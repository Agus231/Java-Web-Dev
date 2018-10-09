package edu.epam.first.repository.specification;

import edu.epam.first.entity.Sphere;
import edu.epam.first.repository.Specification;

public class SphereSpecificationRadiusLess implements Specification<Sphere> {
    private double maxRadius;

    public SphereSpecificationRadiusLess(double maxRadius){
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
