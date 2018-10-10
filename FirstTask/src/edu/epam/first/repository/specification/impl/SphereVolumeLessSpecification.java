package edu.epam.first.repository.specification.impl;

import edu.epam.first.entity.Sphere;
import edu.epam.first.registrator.Warehouse;
import edu.epam.first.repository.specification.Specification;

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
    public boolean specified(Sphere sphere) {
        Warehouse warehouse = Warehouse.getInstance();
        var volume = warehouse.getParameters(sphere).getVolume();
        return (volume < maxVolume);
    }
}
