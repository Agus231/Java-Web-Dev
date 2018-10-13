package edu.epam.first.repository.specification.impl;

import edu.epam.first.entity.Sphere;
import edu.epam.first.registrator.Warehouse;
import edu.epam.first.repository.specification.Specification;

public class SphereAreaMoreSpecification implements Specification<Sphere> {
    private double minArea;

    public SphereAreaMoreSpecification(double area){
        this.minArea = area;
    }

    public void setMinArea(double minArea) {
        this.minArea = minArea;
    }

    public double getMinArea() {
        return minArea;
    }

    @Override
    public boolean specified(Sphere sphere) {
        var warehouse = Warehouse.getInstance();
        double area = warehouse.getParameters(sphere).getArea();
        return (area > minArea);
    }
}
