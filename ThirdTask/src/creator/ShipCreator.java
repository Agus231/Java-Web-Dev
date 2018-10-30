package creator;

import entity.Ship;
import entity.Warehouse;

import java.util.Random;

public class ShipCreator {
    public static final int MAX_SHIP_WAREHOUSE_CAPACITY = 100;

    //todo: islloading and max
    public static Ship createShip(String name){
        Random random = new Random();

        boolean isLoading  = random.nextBoolean();
        int shipContainers = 1 + random.nextInt(MAX_SHIP_WAREHOUSE_CAPACITY);
        Warehouse warehouse = WarehouseCreator.createWarehouse(shipContainers, MAX_SHIP_WAREHOUSE_CAPACITY);

        int containerDelta;
        if (isLoading) {
            containerDelta = 1 + random.nextInt(MAX_SHIP_WAREHOUSE_CAPACITY - shipContainers);
        }
        else{
            containerDelta = 1 + random.nextInt(shipContainers);
        }

        var result = new Ship(name, containerDelta);
        result.setLoading(isLoading);
        result.setShipWarehouse(warehouse);

        return result;
    }

}
