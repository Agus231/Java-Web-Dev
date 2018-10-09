package edu.epam.first.action;

import edu.epam.first.entity.Point3D;
import edu.epam.first.entity.Sphere;
import edu.epam.first.exception.SphereException;

import static java.lang.Math.PI;

public class SphereAction {
    private static SphereAction instance;

    private SphereAction(){}

    public static SphereAction getInstance(){
        if (instance == null){
            instance = new SphereAction();
        }

        return instance;
    }

    public double calculateVolume(Sphere sphere) {
        return (4.0/3 * PI * Math.pow(sphere.getRadius(), 3));
    }

    public double calculateArea(Sphere sphere) {
        return (4.0 * PI * Math.pow(sphere.getRadius(), 2));
    }

    public boolean isSphere(Object o){
        if(!(o instanceof Sphere)){
            return false;
        }

        Sphere sphere = (Sphere) o;

        return (sphere.getRadius() != 0);
    }

    public boolean doTouchOxy(Sphere sphere){
        double radius = sphere.getRadius();
        Point3D center = sphere.getCenter();

        return (radius - Math.abs(center.getZ()) == 0);
    }

    public boolean doTouchOxz(Sphere sphere){
        double radius = sphere.getRadius();
        Point3D center = sphere.getCenter();

        return (radius - Math.abs(center.getY()) == 0);
    }

    public boolean doTouchOyz(Sphere sphere){
        double radius = sphere.getRadius();
        Point3D center = sphere.getCenter();

        return (radius - Math.abs(center.getX()) == 0);
    }

    public double calculateSegmentVolume(Sphere sphere, double h) throws SphereException {
        if (!isSphere(sphere)) throw new SphereException("Can't calculate segment volume for non sphere object.");

        return (PI * Math.pow(h, 2) * (sphere.getRadius() - h / 3));
    }

    public double relationOxy(Sphere sphere) throws SphereException {
        double absZ = Math.abs(sphere.getCenter().getZ());
        double radius = sphere.getRadius();

        if (radius <= absZ) return 0;

        double volumeFirstSegment = calculateSegmentVolume(sphere, radius - absZ);
        double volumeSecondSegment = calculateVolume(sphere) - volumeFirstSegment;

        return (volumeFirstSegment / volumeSecondSegment);
    }

    public double relationOxz(Sphere sphere) throws SphereException {
        double absY = Math.abs(sphere.getCenter().getY());
        double radius = sphere.getRadius();

        if (radius <= absY) return 0;

        double volumeFirstSegment = calculateSegmentVolume(sphere, radius - absY);
        double volumeSecondSegment = calculateVolume(sphere) - volumeFirstSegment;

        return (volumeFirstSegment / volumeSecondSegment);
    }

    public double relationOyz(Sphere sphere) throws SphereException {
        double absX = Math.abs(sphere.getCenter().getX());
        double radius = sphere.getRadius();

        if (radius <= absX) return 0;

        double volumeFirstSegment = calculateSegmentVolume(sphere, radius - absX);
        double volumeSecondSegment = calculateVolume(sphere) - volumeFirstSegment;

        return (volumeFirstSegment / volumeSecondSegment);
    }

}
