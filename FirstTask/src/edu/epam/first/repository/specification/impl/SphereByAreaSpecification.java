package edu.epam.first.repository.specification.impl;

import edu.epam.first.entity.Sphere;
import edu.epam.first.registrator.Warehouse;
import edu.epam.first.repository.specification.Specification;

import java.util.function.Predicate;

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
    public Predicate<Sphere> specified() {
        var warehouse = Warehouse.getInstance();

        return (s) ->{
            double area = warehouse.getParameters(s).getArea();
            return area == desiredArea;
        };
    }
}
