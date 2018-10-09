package edu.epam.first.entity;

import edu.epam.first.observer.SphereEvent;
import edu.epam.first.observer.SphereObserver;
import edu.epam.first.observer.Subject;
import edu.epam.first.util.IdGenerator;

public class Sphere implements Subject<SphereObserver> {
    private final static String DOUBLE_SPLITTER = "\\s+";

    private long sphereId;
    private Point3D center;
    private double radius;
    private SphereObserver observer;

    //todo: smth with constructor
    public Sphere(String string){
        sphereId = IdGenerator.generateId();

        String[] args = string.split(DOUBLE_SPLITTER);

        center = new Point3D(Double.parseDouble(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]));
        this.radius = Double.parseDouble(args[3]);
    }

    public Sphere(Point3D center, double radius){
        this.sphereId = IdGenerator.generateId();
        this.center = center;
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public Point3D getCenter() {
        return center;
    }

    public long getSphereId() {
        return sphereId;
    }

    public void setCenter(Point3D center) {
        this.center = center;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        notifyObserver();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }

        Sphere sphere = (Sphere) obj;
        return (sphereId == sphere.sphereId && center.equals(sphere.center) && radius == sphere.radius);
    }

    @Override
    public int hashCode() {
        return (int) ((sphereId + center.hashCode() + radius * 41) % 57);
    }

    @Override
    public String toString() {
        return "Sphere[center:"+center + ", radius=" + radius + "]";
    }

    public boolean equalsSphere(Sphere sphere) {
        if (sphere == this){
            return true;
        }

        if (sphere == null){
            return false;
        }

        return (center.equals(sphere.center) && radius == sphere.radius);
    }

    @Override
    public void attachObserver(SphereObserver observer) {
        this.observer = observer;
    }

    @Override
    public void detachObserver() {
        this.observer = null;
    }

    @Override
    public void notifyObserver() {
        if (observer != null){
            observer.handleEvent(new SphereEvent(this));
        }
    }
}
