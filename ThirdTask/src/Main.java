import creator.ShipCreator;
import entity.Ship;
import entity.Train;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    private static final int SHIPS_NUMBER = 12;

    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask train = new Train();
        timer.schedule(train, 4000, 1000);

        for (int i = 0; i < SHIPS_NUMBER; i++) {
            Ship ship = ShipCreator.createShip("Thread : " + i);
            ship.start();
        }

    }
}
