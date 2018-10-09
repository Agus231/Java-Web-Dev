package edu.epam.first.repository.specification;

import edu.epam.first.entity.Sphere;
import edu.epam.first.registrator.Registrator;
import edu.epam.first.repository.Specification;

public class SphereSpecificationByVolume implements Specification<Sphere> {
    private double desiredVolume;

    public SphereSpecificationByVolume(double volume){
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
        Registrator registrator = Registrator.getInstance();
        var volume = registrator.getParameters(sphere).getVolume();
        return (volume == desiredVolume);
    }
}
