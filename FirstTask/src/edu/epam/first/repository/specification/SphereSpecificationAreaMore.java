package edu.epam.first.repository.specification;

import edu.epam.first.entity.Sphere;
import edu.epam.first.exception.SphereException;
import edu.epam.first.registrator.Registrator;
import edu.epam.first.repository.Specification;

public class SphereSpecificationAreaMore implements Specification<Sphere> {
    private double minArea;

    public SphereSpecificationAreaMore(double area){
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
        Registrator registrator = Registrator.getInstance();
        var area = registrator.getParameters(sphere).getArea();
        return (area > minArea);
    }
}
