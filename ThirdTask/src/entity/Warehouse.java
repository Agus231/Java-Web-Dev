package entity;

public class Warehouse {
    private int currentContainers;
    private int maxContainers;

    private static double MINIMUM_PERCENTAGE = 0.2;
    private static double MAXIMUM_PERCENTAGE = 0.9;

    private static double CHANGE_PERCENTAGE = 0.3;

    public Warehouse(int currentContainers, int maxContainers){
        this.currentContainers = currentContainers;
        this.maxContainers = maxContainers;
    }

    public void addContainers(int containers){
            currentContainers += containers;
    }

    public void retriveContainers(int containers){
            currentContainers -= containers;
    }

    public void setCurrentContainers(int currentContainers) {
        this.currentContainers = currentContainers;
    }

    public void setMaxContainers(int maxContainers) {
        this.maxContainers = maxContainers;
    }

    public int getCurrentContainers() {
        return currentContainers;
    }

    public int getMaxContainers() {
        return maxContainers;
    }

    @Override
    public String toString() {
        return "Warehouse[max = " + maxContainers + "; current = " + currentContainers + "];";
    }
}
