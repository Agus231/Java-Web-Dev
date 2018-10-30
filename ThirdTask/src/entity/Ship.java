package entity;

import exception.PortException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class Ship extends Thread{
    private static Logger logger = LogManager.getLogger();
    private Warehouse shipWarehouse;
    private boolean isLoading;
    private int delta;

    public Ship(String threadName, int delta){
        Thread.currentThread().setName(threadName);
        this.delta = delta;
    }

    public void setShipWarehouse(Warehouse shipWarehouse) {
        this.shipWarehouse = shipWarehouse;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }

    public Warehouse getShipWarehouse() {
        return shipWarehouse;
    }

    @Override
    public void run() {
        var instance = Port.getInstance();

        Berth berth = null;
        try {
            berth = instance.getResource();
        } catch (PortException e) {
            logger.error("Exception from : " + Thread.currentThread().getName() + "; While getting berth.");
        }

        var portWarehouse = instance.getPortWarehouse();
        logger.debug(Thread.currentThread().getName() + "; Got berth : " + berth +
                        "; Working with it; Ship wh: " + shipWarehouse + "; delta = " + delta +"  Port wh: " + portWarehouse);

        if (isLoading){
            instance.retrieveContainers(delta);
            shipWarehouse.addContainers(delta);
        }
        else {
            instance.addContainers(delta);
            shipWarehouse.retriveContainers(delta);
        }

        try {
            TimeUnit.MILLISECONDS.sleep(delta * 100);
            logger.debug(Thread.currentThread().getName() + "; Done with berth : " + berth +
                    "; Ship wh: " + shipWarehouse);
        } catch (InterruptedException e) {
            logger.error("Exception from : " + Thread.currentThread().getName() + "; While working with berth.");
        }

        instance.returnResource(berth);
    }
}
