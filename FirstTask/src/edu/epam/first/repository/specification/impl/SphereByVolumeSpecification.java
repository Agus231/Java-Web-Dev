package edu.epam.first.repository.specification.impl;

import edu.epam.first.entity.Sphere;
import edu.epam.first.registrator.Warehouse;
import edu.epam.first.repository.specification.Specification;

import java.util.function.Predicate;

public class SphereByVolumeSpecification implements Specification<Sphere> {
    private double desiredVolume;

    public SphereByVolumeSpecification(double volume){
        this.desiredVolume = volume;
    }

    public void setDesiredVolume(double desiredVolume) {
        this.desiredVolume = desiredVolume;
    }

    public double getDesiredVolume() {
        return desiredVolume;
    }

    @Override
    public Predicate<Sphere> specified() {
        var warehouse = Warehouse.getInstance();

        return (s) -> {
            double volume = warehouse.getParameters(s).getVolume();
            return (volume == desiredVolume);
        };
    }
}
