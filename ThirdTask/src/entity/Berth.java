package entity;

import util.IdGenerator;

public class Berth {
    private long berthId;
    private Ship ship;

    public Berth(){
        berthId = IdGenerator.getId();
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    @Override
    public String toString() {
        return "Berth[id = " + berthId + "]";
    }
}
