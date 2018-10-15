package edu.epam.first.repository.specification.impl;

import edu.epam.first.entity.Sphere;
import edu.epam.first.registrator.Warehouse;
import edu.epam.first.repository.specification.Specification;

import java.util.function.Predicate;

public class SphereVolumeLessSpecification implements Specification<Sphere> {
    private double maxVolume;

    public SphereVolumeLessSpecification(double volume){
        this.maxVolume = volume;
    }

    public void setMaxVolume(double maxVolume) {
        this.maxVolume = maxVolume;
    }

    public double getMaxVolume() {
        return maxVolume;
    }

    @Override
    public Predicate<Sphere> specified() {
        var warehouse = Warehouse.getInstance();
        return (s) -> {
            double volume = warehouse.getParameters(s).getVolume();
            return (volume < maxVolume);
        };
    }
}
