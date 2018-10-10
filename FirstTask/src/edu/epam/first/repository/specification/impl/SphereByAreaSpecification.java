package edu.epam.first.repository.specification.impl;

import edu.epam.first.entity.Sphere;
import edu.epam.first.registrator.Warehouse;
import edu.epam.first.repository.specification.Specification;

public class SphereByAreaSpecification implements Specification<Sphere> {
    private double desiredArea;

    public SphereByAreaSpecification(double area){
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
        Warehouse warehouse = Warehouse.getInstance();
        var area = warehouse.getParameters(sphere).getArea();
        return (area == desiredArea);
    }
}
