package edu.epam.third.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ship extends Thread{
    private static Logger logger = LogManager.getLogger();
    private Warehouse shipWarehouse;
    private List<Integer> shipOperations;

    public Ship(Warehouse shipWarehouse){
        this.shipWarehouse = shipWarehouse;
    }

    public void setShipOperations(List<Integer> shipOperations) {
        this.shipOperations = shipOperations;
    }

    @Override
    public void run() {
        var instance = Port.getInstance();
        Berth berth = instance.getResource();

        var portWarehouse = instance.getPortWarehouse();
        logger.debug(Thread.currentThread().getName() + "; Got berth : " + berth +
                        "; Working with it; Ship wh: " + shipWarehouse + " Port wh: " + portWarehouse);

        for (Integer operation: shipOperations) {
            if (operation > 0) {
                instance.retrieveContainers(operation);
                shipWarehouse.addContainers(operation);
            }
            else {
                instance.addContainers(-operation);
                shipWarehouse.retrieveContainers(-operation);
            }
            try {
                TimeUnit.MILLISECONDS.sleep(operation * 100);
                logger.debug(Thread.currentThread().getName() + "; Done with berth : " + berth +
                        "; Ship wh: " + shipWarehouse + " Operation: " + operation + "; Port wh: " + portWarehouse);
            } catch (InterruptedException e) {
                logger.error("Exception from : " + Thread.currentThread().getName() + "; While working with berth.");
            }

        }

        instance.returnResource(berth);
    }
}
