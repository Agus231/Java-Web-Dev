package edu.epam.first.repository.specification;

import edu.epam.first.entity.Sphere;
import edu.epam.first.repository.Specification;

public class SphereSpecificationByVolume implements Specification<Sphere> {
    @Override
    public boolean specified(Sphere sphere) {
        return false;
    }
}
