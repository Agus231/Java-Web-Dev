package entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Warehouse {
    private AtomicInteger currentContainers;
    private int maxContainers;

    private static double MINIMUM_PERCENTAGE = 0.2;
    private static double MAXIMUM_PERCENTAGE = 0.8;

    public Warehouse(int currentContainers, int maxContainers){
        this.currentContainers = new AtomicInteger(currentContainers);
        this.maxContainers = maxContainers;
    }

    public void addContainers(int containers){
        currentContainers.getAndAdd(containers);
    }

    public void retrieveContainers(int containers){
        currentContainers.getAndAdd(-containers);
    }

    public void setCurrentContainers(int currentContainers) {
        this.currentContainers = new AtomicInteger(currentContainers);
    }

    public void setMaxContainers(int maxContainers) {
        this.maxContainers = maxContainers;
    }

    public int getCurrentContainers() {
        return currentContainers.get();
    }

    public int getMaxContainers() {
        return maxContainers;
    }

    public boolean isFull(){
        double relation = currentContainers.doubleValue() / maxContainers;
        return relation >= MAXIMUM_PERCENTAGE;
    }

    public boolean isEmpty() {
        double relation = currentContainers.doubleValue() / maxContainers;
        return relation <= MINIMUM_PERCENTAGE;
    }

    @Override
    public String toString() {
        return "Warehouse[max = " + maxContainers + "; current = " + currentContainers + "];";
    }
}
