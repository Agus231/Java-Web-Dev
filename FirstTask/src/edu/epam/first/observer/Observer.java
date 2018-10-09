package edu.epam.first.observer;

import java.util.EventObject;

public interface Observer<T extends EventObject> {
    void handleEvent(T t);
}
