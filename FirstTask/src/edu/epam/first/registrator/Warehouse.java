package edu.epam.first.registrator;

import edu.epam.first.action.SphereAction;
import edu.epam.first.entity.Sphere;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Warehouse {
    private static final Warehouse instance = new Warehouse();
    private Map<Long, Parameters> parametersMap;

    private Warehouse(){
        parametersMap = new HashMap<>();
    };

    public static Warehouse getInstance(){
        return instance;
    }

    public Parameters getParameters(Sphere sphere){
        return parametersMap.get(sphere.getSphereId());
    }

    public void registerSpheres(List<Sphere> spheres){
        for (Sphere sphere: spheres) {
            registerSphere(sphere);
        }
    }

    public void registerSphere(Sphere sphere){
        var sphereAction = SphereAction.getInstance();
        var parameters = new Parameters(sphereAction.calculateArea(sphere), sphereAction.calculateVolume(sphere));

        parametersMap.put(sphere.getSphereId(), parameters);
    }

    public void unregisterSpheres(){
        parametersMap = new HashMap<>();
    }

    public void unregisterSphere(Long id){
        parametersMap.remove(id);
    }
}
