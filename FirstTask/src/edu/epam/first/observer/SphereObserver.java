package edu.epam.first.observer;

import edu.epam.first.entity.Sphere;
import edu.epam.first.observer.event.SphereCreationEvent;
import edu.epam.first.observer.event.SphereUpdateEvent;
import edu.epam.first.registrator.Warehouse;
import edu.epam.first.repository.SphereRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EventObject;

public class SphereObserver implements Observer<EventObject> {
    private static Logger logger = LogManager.getLogger();

    //todo: handler different events, two observers or instanceof
    @Override
    public void handleEvent(EventObject event) {
        Sphere sphere = (Sphere) event.getSource();

        if (event instanceof SphereCreationEvent){
            creationRegister(sphere);
        }
        else if (event instanceof SphereUpdateEvent){
            updateParameters(sphere);
        }
        else {
            logger.warn("This type of event can't be handled.");
        }
    }

    private void updateParameters(Sphere sphere){
        var warehouse = Warehouse.getInstance();
        warehouse.registerSphere(sphere);
    }

    private void creationRegister(Sphere sphere){
        var warehouse = Warehouse.getInstance();
        var repository = SphereRepository.getInstance();

        repository.add(sphere);
        warehouse.registerSphere(sphere);
    }
}