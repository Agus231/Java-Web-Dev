package edu.epam.first.registrator;

import java.util.HashMap;

public class Registrator {
    private static final Registrator instance = new Registrator();
    private HashMap<Long, Parameters> registratorMap;

    private Registrator(){
        registratorMap = new HashMap<>();
    }

    public static Registrator getInstance(){
        return instance;
    }

    public HashMap<Long, Parameters> getRegistratorMap() {
        return registratorMap;
    }
}
