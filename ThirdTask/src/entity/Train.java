package entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.TimerTask;

public class Train extends TimerTask {
    private static final double CHANGE_PERCENTAGE = 0.3;
    private static final int MAX_TRAIN_CAPACITY = 1_000;

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void run() {
        var port = Port.getInstance();
        var warehouse = port.getPortWarehouse();
        var isEmptyCondition = port.getIsEmpty();
        var isFullCondition = port.getIsFull();
        //lock for condition
        var portLock = port.getLock();

        try {
            portLock.lock();
            if (warehouse.isEmpty()) {
                warehouse.addContainers((int) (CHANGE_PERCENTAGE * MAX_TRAIN_CAPACITY));
                logger.info("isEmptyCondition signaled from train");
                isEmptyCondition.signalAll();
            } else if (warehouse.isFull()) {
                warehouse.retrieveContainers((int) (CHANGE_PERCENTAGE * MAX_TRAIN_CAPACITY));
                logger.info("isFullCondition signaled from train");
                isFullCondition.signalAll();
            }
        } finally {
            portLock.unlock();
        }
    }
}
