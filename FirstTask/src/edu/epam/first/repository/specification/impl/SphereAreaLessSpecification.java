package edu.epam.first.repository.specification.impl;

import edu.epam.first.entity.Sphere;
import edu.epam.first.registrator.Warehouse;
import edu.epam.first.repository.specification.Specification;

public class SphereAreaLessSpecification implements Specification<Sphere> {
    private double maxArea;

    public SphereAreaLessSpecification(double area){
        this.maxArea = area;
    }

    public void setMaxArea(double maxArea) {
        this.maxArea = maxArea;
    }

    public double getMaxArea() {
        return maxArea;
    }

    @Override
    public boolean specified(Sphere sphere) {
        Warehouse warehouse = Warehouse.getInstance();
        var area = warehouse.getParameters(sphere).getArea();
        return (area < maxArea);
    }
}
