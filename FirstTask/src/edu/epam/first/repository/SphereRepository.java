package edu.epam.first.repository;

import edu.epam.first.entity.Sphere;

import java.util.ArrayList;
import java.util.List;

public class SphereRepository implements Repository<Sphere>{
    private List<Sphere> spheres;

    public SphereRepository(){
        spheres = new ArrayList<Sphere>();
    }

    @Override
    public void add(Sphere sphere) {
        spheres.add(sphere);
    }

    @Override
    public void remove(Sphere sphere) {
        spheres.remove(sphere);
    }

    //todo: add realization
    @Override
    public List<Sphere> query(Specification<Sphere> specification) {
        return null;
    }
}
