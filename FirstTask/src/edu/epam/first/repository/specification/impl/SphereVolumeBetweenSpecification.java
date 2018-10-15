package edu.epam.first.repository.specification.impl;

import edu.epam.first.entity.Sphere;
import edu.epam.first.registrator.Warehouse;
import edu.epam.first.repository.specification.Specification;

import java.util.function.Predicate;

public class SphereVolumeBetweenSpecification implements Specification<Sphere> {
    private double minVolume;
    private double maxVolume;

    public SphereVolumeBetweenSpecification(double min, double max){
        this.minVolume = min;
        this.maxVolume = max;
    }

    public double getMaxVolume() {
        return maxVolume;
    }

    public double getMinVolume() {
        return minVolume;
    }

    public void setMaxVolume(double maxVolume) {
        this.maxVolume = maxVolume;
    }

    public void setMinVolume(double minVolume) {
        this.minVolume = minVolume;
    }

    @Override
    public Predicate<Sphere> specified() {
        var warehouse = Warehouse.getInstance();
        return (s) -> {
            double volume = warehouse.getParameters(s).getVolume();
            return (volume >= minVolume && volume < maxVolume);
        };
    }
}
