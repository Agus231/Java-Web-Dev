package edu.epam.first.repository.specification.impl;

import edu.epam.first.entity.Sphere;
import edu.epam.first.registrator.Warehouse;
import edu.epam.first.repository.specification.Specification;

import java.util.function.Predicate;

public class SphereVolumeMoreSpecification implements Specification<Sphere> {
    private double minVolume;

    public SphereVolumeMoreSpecification(double volume){
        this.minVolume = volume;
    }

    public void setMinVolume(double minVolume) {
        this.minVolume = minVolume;
    }

    public double getMinVolume() {
        return minVolume;
    }

    @Override
    public Predicate<Sphere> specified() {
        var warehouse = Warehouse.getInstance();
        return (s) -> {
            double volume = warehouse.getParameters(s).getVolume();
            return (volume > minVolume);
        };
    }
}
