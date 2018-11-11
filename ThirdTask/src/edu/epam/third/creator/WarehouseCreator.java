package edu.epam.third.creator;

import edu.epam.third.entity.Warehouse;

public class WarehouseCreator {
    public static Warehouse createWarehouse(int currentContainers, int maxContainers){
        return new Warehouse(currentContainers, maxContainers);
    }
}
