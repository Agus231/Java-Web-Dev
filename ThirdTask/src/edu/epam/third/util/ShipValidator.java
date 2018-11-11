package edu.epam.third.util;

import edu.epam.third.exception.PortException;
import edu.epam.third.reader.ShipReader;

public class ShipValidator {
    public boolean validateInitialContainers(String initialString) throws PortException {
        int containers;
        try {
            containers = Integer.parseInt(initialString);
        } catch (NumberFormatException e){
            throw new PortException("This value can't be parsed for initialization of ship warehouse: " + initialString, e);
        }

        return containers >= 0 && containers <= ShipReader.MAX_SHIP_WAREHOUSE_CAPACITY;
    }


}
