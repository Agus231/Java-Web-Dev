package edu.epam.first.repository.specification.impl;

import edu.epam.first.entity.Sphere;
import edu.epam.first.registrator.Warehouse;
import edu.epam.first.repository.specification.Specification;

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
    public boolean specified(Sphere sphere) {
        Warehouse warehouse = Warehouse.getInstance();
        var volume = warehouse.getParameters(sphere).getVolume();
        return (volume >= minVolume && volume < maxVolume);
    }
}
