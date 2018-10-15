package edu.epam.first.observer;

import edu.epam.first.entity.Sphere;
import java.util.EventObject;

public class SphereEvent extends EventObject {
    private Type eventType;

    public enum Type {
        CREATION, UPDATE
    }

    public SphereEvent(Sphere source, Type type) {
        super(source);
        eventType = type;
    }

    public Type getEventType() {
        return eventType;
    }

    @Override
    public Sphere getSource() {
        return (Sphere)super.getSource();
    }
}
