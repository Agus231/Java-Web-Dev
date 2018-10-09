package edu.epam.first.registrator;

import edu.epam.first.action.SphereAction;
import edu.epam.first.entity.Sphere;

import java.util.HashMap;
import java.util.List;

public class Registrator {
    private static final Registrator instance = new Registrator();
    private HashMap<Long, Parameters> registratorMap;

    private Registrator(){
    };

    public static Registrator getInstance(){
        return instance;
    }

    public Parameters getParameters(Sphere sphere){
        return registratorMap.get(sphere.getSphereId());
    }

    public void registerSpheres(List<Sphere> spheres){
        var sphereAction = SphereAction.getInstance();
        var registration = new HashMap<Long, Parameters>();

        for (Sphere sphere: spheres) {
            var parameters = new Parameters(sphereAction.calculateArea(sphere), sphereAction.calculateVolume(sphere));
            registration.put(sphere.getSphereId(), parameters);
        }

        registratorMap = registration;
    }
}
