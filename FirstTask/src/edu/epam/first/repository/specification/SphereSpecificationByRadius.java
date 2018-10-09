package edu.epam.first.repository.specification;

import edu.epam.first.entity.Sphere;
import edu.epam.first.repository.Specification;

public class SphereSpecificationByRadius implements Specification<Sphere> {
    private double desiredRadius;

    public SphereSpecificationByRadius(double desiredRadius){
        this.desiredRadius = desiredRadius;
    }

    public void setDesiredRadius(double desiredRadius) {
        this.desiredRadius = desiredRadius;
    }

    public double getDesiredRadius() {
        return desiredRadius;
    }

    @Override
    public boolean specified(Sphere sphere) {
        return (sphere.getRadius() == desiredRadius);
    }
}
