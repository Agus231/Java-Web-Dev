package edu.epam.first.repository.specification;

import edu.epam.first.entity.Sphere;
import edu.epam.first.registrator.Registrator;
import edu.epam.first.repository.Specification;

public class SphereSpecificationVolumeMore implements Specification<Sphere> {
    private double minVolume;

    public SphereSpecificationVolumeMore(double volume){
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
        Registrator registrator = Registrator.getInstance();
        var volume = registrator.getParameters(sphere).getVolume();
        return (volume > minVolume);
    }
}
