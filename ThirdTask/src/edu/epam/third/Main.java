package edu.epam.third;

import edu.epam.third.entity.Ship;
import edu.epam.third.reader.ShipReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ShipReader shipReader = new ShipReader();
        List<Ship> ships = shipReader.shipsFromFile("./data/input.txt");

        for (Ship ship: ships) {
            ship.start();
        }
    }
}
