package edu.epam.first.observer;

import edu.epam.first.entity.Sphere;
import java.util.EventObject;

public class SphereEvent extends EventObject {
    private EventType eventType;

    public SphereEvent(Sphere source, EventType type) {
        super(source);
        eventType = type;
    }

    public EventType getEventType() {
        return eventType;
    }

    @Override
    public Sphere getSource() {
        return (Sphere)super.getSource();
    }
}
