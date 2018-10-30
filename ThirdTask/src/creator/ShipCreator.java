package creator;

import entity.Ship;
import entity.Warehouse;

import java.util.Random;

//todo: random bounds, atomic intger?
public class ShipCreator {

    private static final int RANDOM_BOUND = 100;

    public static Ship createShip(String name){
        Random random = new Random();

        boolean isLoading  = random.nextBoolean();
        int shipContainers = random.nextInt(RANDOM_BOUND);
        Warehouse warehouse = WarehouseCreator.createWarehouse(shipContainers, RANDOM_BOUND);
        int containerDelta;
        if (isLoading) {
            containerDelta = random.nextInt(RANDOM_BOUND - shipContainers);
        }
        else{
            containerDelta = random.nextInt(shipContainers);
        }

        var result = new Ship(name, containerDelta);
        result.setLoading(isLoading);
        result.setShipWarehouse(warehouse);

        return result;
    }

}
