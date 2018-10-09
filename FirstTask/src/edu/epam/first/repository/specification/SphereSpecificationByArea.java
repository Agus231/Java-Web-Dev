package edu.epam.first.repository.specification;

import edu.epam.first.entity.Sphere;
import edu.epam.first.registrator.Registrator;
import edu.epam.first.repository.Specification;

public class SphereSpecificationByArea implements Specification<Sphere> {
    private double desiredArea;

    public SphereSpecificationByArea(double area){
        this.desiredArea = area;
    }

    public void setDesiredArea(double desiredArea) {
        this.desiredArea = desiredArea;
    }

    public double getDesiredId() {
        return desiredArea;
    }

    @Override
    public boolean specified(Sphere sphere) {
        Registrator registrator = Registrator.getInstance();
        var area = registrator.getParameters(sphere).getArea();
        return (area == desiredArea);
    }
}
