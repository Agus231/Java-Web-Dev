package edu.epam.first.repository;

import edu.epam.first.entity.Sphere;
import edu.epam.first.registrator.Warehouse;
import edu.epam.first.repository.specification.Specification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SphereRepository implements Repository<Sphere>{
    private static final SphereRepository instance = new SphereRepository();
    private List<Sphere> spheres;

    private SphereRepository(){
        spheres = new ArrayList<>();
    }

    public static SphereRepository getInstance(){
        return instance;
    }

    public List<Sphere> getSpheres() {
        return spheres;
    }

    public void clearRepository(){
        spheres = new ArrayList<>();
    }

    public List<Sphere> sort(Comparator<Sphere> comparator){
        return spheres.stream().sorted(comparator).collect(Collectors.toList());
    }

    @Override
    public void add(Sphere sphere) {
        var registrator = Warehouse.getInstance();
        spheres.add(sphere);
        registrator.registerSphere(sphere);
    }

    @Override
    public void remove(Sphere sphere) {
        var registrator = Warehouse.getInstance();
        spheres.remove(sphere);
        registrator.unregisterSphere(sphere.getSphereId());
    }

    @Override
    public List<Sphere> query(Specification<Sphere> specification) {
        return spheres.stream().filter(specification::specified).collect(Collectors.toList());
    }
}
