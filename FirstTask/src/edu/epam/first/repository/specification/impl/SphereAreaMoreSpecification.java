package edu.epam.first.repository.specification.impl;

import edu.epam.first.entity.Sphere;
import edu.epam.first.registrator.Warehouse;
import edu.epam.first.repository.specification.Specification;

import java.util.function.Predicate;

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
    public Predicate<Sphere> specified() {
        var warehouse = Warehouse.getInstance();

        return (s) -> {
            double area = warehouse.getParameters(s).getArea();
            return (area > minArea);
        };
    }
}
