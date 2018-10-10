package edu.epam.first.observer;

import edu.epam.first.action.SphereAction;
import edu.epam.first.registrator.Warehouse;

public class SphereObserver implements Observer<SphereEvent> {
    @Override
    public void handleEvent(SphereEvent event) {
        var warehouse = Warehouse.getInstance();
        var sphereAction = SphereAction.getInstance();

        var sphere = event.getSource();

        double area = sphereAction.calculateArea(sphere);
        double volume = sphereAction.calculateVolume(sphere);

        var parameters = warehouse.getParameters(sphere);

        parameters.setArea(area);
        parameters.setVolume(volume);
    }
}
