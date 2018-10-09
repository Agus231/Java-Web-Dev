package edu.epam.first.repository.specification;

import edu.epam.first.entity.Sphere;
import edu.epam.first.exception.SphereException;
import edu.epam.first.registrator.Registrator;
import edu.epam.first.repository.Specification;

public class SphereSpecificationAreaLess implements Specification<Sphere> {
    private double maxArea;

    public SphereSpecificationAreaLess(double area){
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
        Registrator registrator = Registrator.getInstance();
        var area = registrator.getParameters(sphere).getArea();
        return (area < maxArea);
    }
}
