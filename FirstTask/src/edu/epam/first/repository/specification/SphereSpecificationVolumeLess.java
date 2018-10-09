package edu.epam.first.repository.specification;

import edu.epam.first.entity.Sphere;
import edu.epam.first.registrator.Registrator;
import edu.epam.first.repository.Specification;

public class SphereSpecificationVolumeLess implements Specification<Sphere> {
    private double maxVolume;

    public SphereSpecificationVolumeLess(double volume){
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
        Registrator registrator = Registrator.getInstance();
        var volume = registrator.getParameters(sphere).getVolume();
        return (volume < maxVolume);
    }
}
