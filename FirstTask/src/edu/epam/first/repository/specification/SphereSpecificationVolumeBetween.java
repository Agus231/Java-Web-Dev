package edu.epam.first.repository.specification;

import edu.epam.first.entity.Sphere;
import edu.epam.first.registrator.Registrator;
import edu.epam.first.repository.Specification;

public class SphereSpecificationVolumeBetween implements Specification<Sphere> {
    private double minVolume;
    private double maxVolume;

    public SphereSpecificationVolumeBetween(double min, double max){
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
        Registrator registrator = Registrator.getInstance();
        var volume = registrator.getParameters(sphere).getVolume();
        return (volume >= minVolume && volume < maxVolume);
    }
}
