package edu.epam.first.repository.specification.impl;

import edu.epam.first.entity.Sphere;
import edu.epam.first.registrator.Warehouse;
import edu.epam.first.repository.specification.Specification;

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
    public boolean specified(Sphere sphere) {
        var warehouse = Warehouse.getInstance();
        double volume = warehouse.getParameters(sphere).getVolume();
        return (volume == desiredVolume);
    }
}
