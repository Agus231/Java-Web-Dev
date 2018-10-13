package edu.epam.first.observer.event;

import edu.epam.first.entity.Sphere;
import java.util.EventObject;

public class SphereUpdateEvent extends EventObject {
    public SphereUpdateEvent(Sphere source) {
        super(source);
    }

    @Override
    public Sphere getSource() {
        return (Sphere)super.getSource();
    }
}
