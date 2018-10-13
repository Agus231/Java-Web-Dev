package edu.epam.first.observer.event;

import edu.epam.first.entity.Sphere;
import java.util.EventObject;

public class SphereCreationEvent extends EventObject {
    public SphereCreationEvent(Sphere source) {
        super(source);
    }

    @Override
    public Sphere getSource() {
        return (Sphere)super.getSource();
    }
}

