package entity;

import creator.WarehouseCreator;
import exception.PortException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Port {
    private static Logger logger = LogManager.getLogger();

    private static final int BERTH_COUNT = 3;
    private static final int WAREHOUSE_CONTAINERS = 30;
    private static final int WAREHOUSE_CONTAINERS_MAX = 1_000;

    private static ReentrantLock lock = new ReentrantLock();
    private Semaphore semaphore = new Semaphore(BERTH_COUNT, true);
    private Condition isEmpty = lock.newCondition();
    private Condition isFull = lock.newCondition();

    private static Port instance;
    private static AtomicBoolean isAvailable = new AtomicBoolean(true);

    private Queue<Berth> berthQueue;
    private Warehouse portWarehouse;

    private Port(){
        berthQueue = new LinkedList<>();
        portWarehouse = WarehouseCreator.createWarehouse(WAREHOUSE_CONTAINERS, WAREHOUSE_CONTAINERS_MAX);
        init();
    }

    public static Port getInstance() {
        if (isAvailable.get()) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new Port();
                    isAvailable.set(false);
                }
            } finally {
                lock.unlock();
            }
        }

        return instance;
    }

    private void init(){
        for (int i = 0; i < BERTH_COUNT; i++) {
            berthQueue.add(new Berth());
        }
    }

    public Berth getResource() throws PortException {
        Berth berth;
        try {
            semaphore.acquire();
            lock.lock();
            berth = berthQueue.poll();
        } catch (InterruptedException e) {
           throw new PortException("Thread was interrupted while getting berth.", e);
        } finally {
            lock.unlock();
        }
        return berth;
    }

    public void returnResource(Berth berth){
        try {
            lock.lock();
            berthQueue.add(berth);
        }
        finally {
            semaphore.release();
            lock.unlock();
        }
    }

    //todo: exception
    public void addContainers(int containers) {
        try {
            lock.lock();
            if (portWarehouse.isFull()){
                logger.warn(Thread.currentThread().getName() + " waiting : FULL PORT");
                isFull.await();
            }

            portWarehouse.addContainers(containers);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //todo: exception
    public void retrieveContainers(int containers) {
        try{
            lock.lock();
            if (portWarehouse.isEmpty()){
                logger.warn(Thread.currentThread().getName() + " waiting : EMPTY PORT");
                isEmpty.await();
            }

            portWarehouse.retrieveContainers(containers);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Condition getIsEmpty() {
        return isEmpty;
    }

    public Condition getIsFull() {
        return isFull;
    }

    public Warehouse getPortWarehouse() {
        return portWarehouse;
    }

    public ReentrantLock getLock() {
        return lock;
    }
}