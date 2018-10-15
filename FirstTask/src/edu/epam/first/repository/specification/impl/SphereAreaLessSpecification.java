package edu.epam.first.repository.specification.impl;

import edu.epam.first.entity.Sphere;
import edu.epam.first.registrator.Warehouse;
import edu.epam.first.repository.specification.Specification;

import java.util.function.Predicate;

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
    public Predicate<Sphere> specified() {
        var warehouse = Warehouse.getInstance();

        return (s) -> {
            double area = warehouse.getParameters(s).getArea();
            return (area < maxArea);
        };
    }
}
