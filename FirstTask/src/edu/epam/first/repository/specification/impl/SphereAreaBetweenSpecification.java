package edu.epam.first.repository.specification.impl;

import edu.epam.first.entity.Sphere;
import edu.epam.first.registrator.Warehouse;
import edu.epam.first.repository.specification.Specification;

public class SphereAreaBetweenSpecification implements Specification<Sphere> {
    private double minArea;
    private double maxArea;

    public SphereAreaBetweenSpecification(double min, double max){
        this.minArea = min;
        this.maxArea = max;
    }

    public double getMaxArea() {
        return maxArea;
    }

    public double getMinArea() {
        return minArea;
    }

    public void setMaxArea(double maxArea) {
        this.maxArea = maxArea;
    }

    public void setMinArea(double minArea) {
        this.minArea = minArea;
    }

    @Override
    public boolean specified(Sphere sphere) {
        var warehouse = Warehouse.getInstance();
        double area = warehouse.getParameters(sphere).getArea();
        return (area >= minArea && area < maxArea);
    }
}
