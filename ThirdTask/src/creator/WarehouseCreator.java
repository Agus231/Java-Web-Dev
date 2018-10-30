package creator;

import entity.Warehouse;

public class WarehouseCreator {
    public static Warehouse createWarehouse(int currentContainers, int maxContainers){
        return new Warehouse(currentContainers, maxContainers);
    }
}
