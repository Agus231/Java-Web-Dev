package edu.epam.first.observer;

import edu.epam.first.entity.Sphere;

import java.util.EventObject;

//todo: parametrization?
public class SphereEvent extends EventObject {
    public SphereEvent(Sphere source) {
        super(source);
    }

    @Override
    public Sphere getSource() {
        return (Sphere)super.getSource();
    }
}
