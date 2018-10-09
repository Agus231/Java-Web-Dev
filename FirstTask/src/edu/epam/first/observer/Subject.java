package edu.epam.first.observer;

public interface Subject<T extends Observer> {
    void attachObserver(T observer);
    void detachObserver();
    void notifyObserver();
}
