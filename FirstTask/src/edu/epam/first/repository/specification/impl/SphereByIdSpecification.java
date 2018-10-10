package edu.epam.first.repository.specification.impl;

import edu.epam.first.entity.Sphere;
import edu.epam.first.repository.specification.Specification;

public class SphereByIdSpecification implements Specification<Sphere> {
    private long desiredId;

    public SphereByIdSpecification(long id){
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
