package entity;

public class Ship implements Runnable{
    private int maxCapacity;
    private int currentCapacity;

    public Ship(int maxCapacity, int currentCapacity){
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    @Override
    public void run() {
        Harbor instance = Harbor.getInstance();

        Wharf wharf = instance.getResource();

        System.out.println(wharf);
    }
}
