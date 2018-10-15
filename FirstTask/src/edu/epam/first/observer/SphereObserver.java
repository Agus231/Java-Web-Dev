package edu.epam.first.observer;

import edu.epam.first.entity.Sphere;
import edu.epam.first.registrator.Warehouse;
import edu.epam.first.repository.SphereRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SphereObserver implements Observer<SphereEvent> {
    private static Logger logger = LogManager.getLogger();

    @Override
    public void handleEvent(SphereEvent event) {
        Sphere sphere = event.getSource();

        switch (event.getEventType()){
            case CREATION:
                creationRegister(sphere);
                break;
            case UPDATE:
                updateParameters(sphere);
                break;
                default:
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