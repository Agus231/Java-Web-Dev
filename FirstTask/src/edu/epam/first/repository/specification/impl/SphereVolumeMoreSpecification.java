package edu.epam.first.repository.specification.impl;

import edu.epam.first.entity.Sphere;
import edu.epam.first.registrator.Warehouse;
import edu.epam.first.repository.specification.Specification;

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
    public boolean specified(Sphere sphere) {
        var warehouse = Warehouse.getInstance();
        double volume = warehouse.getParameters(sphere).getVolume();
        return (volume > minVolume);
    }
}
