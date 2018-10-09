package edu.epam.first.repository.specification;

import edu.epam.first.entity.Sphere;
import edu.epam.first.registrator.Registrator;
import edu.epam.first.repository.Specification;

public class SphereSpecificationAreaBetween implements Specification<Sphere> {
    private double minArea;
    private double maxArea;

    public SphereSpecificationAreaBetween(double min, double max){
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
        Registrator registrator = Registrator.getInstance();
        var area = registrator.getParameters(sphere).getArea();
        return (area >= minArea && area < maxArea);
    }
}
