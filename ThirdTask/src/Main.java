import creator.ShipCreator;
import entity.Ship;

public class Main {
    private static final int SHIPS_NUMBER = 120;

    //todo: timerTask
    public static void main(String[] args) {
        for (int i = 0; i < SHIPS_NUMBER; i++) {
            Ship ship = ShipCreator.createShip("Thread : " + i);
            ship.start();
        }

    }
}
