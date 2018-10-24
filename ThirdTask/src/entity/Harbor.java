package entity;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Harbor {
    private static final int WHARF_COUNT = 5;

    private static ReentrantLock lock = new ReentrantLock();
    private static Semaphore semaphore = new Semaphore(WHARF_COUNT, true);

    private static Harbor instance;

    private Queue<Wharf> wharfQueue;

    private Harbor(){
        wharfQueue = new LinkedList<>();
        initWharfs();
    }

    public static Harbor getInstance() {
        lock.lock();
        try {
            if (instance == null) {
                instance = new Harbor();
            }
        } finally {
            lock.unlock();
        }

        return instance;
    }

    private void initWharfs(){
        for (int i = 0; i < WHARF_COUNT; i++) {
            wharfQueue.add(new Wharf());
        }
    }

    //todo: question need synch or not
    public Wharf getResource(){
        Wharf wharf = null;
        try {
            semaphore.acquire();
            lock.lock();
            wharf = wharfQueue.poll();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return wharf;
    }

    public void returnResource(Wharf wharf){
        wharfQueue.add(wharf);
        semaphore.release();
    }
}
