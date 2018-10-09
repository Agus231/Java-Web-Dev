package edu.epam.first.repository.specification;

import edu.epam.first.entity.Sphere;
import edu.epam.first.repository.Specification;

public class SphereSpecificationById implements Specification<Sphere> {
    private long desiredId;

    public SphereSpecificationById(long id){
        this.desiredId = id;
    }

    public void setDesiredId(long desiredId) {
        this.desiredId = desiredId;
    }

    public long getDesiredId() {
        return desiredId;
    }

    @Override
    public boolean specified(Sphere sphere) {
        return (sphere.getSphereId() == desiredId);
    }
}
