package edu.epam.third.reader;

import edu.epam.third.creator.WarehouseCreator;
import edu.epam.third.entity.Ship;
import edu.epam.third.exception.PortException;
import edu.epam.third.util.ShipValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShipReader {
    private static Logger logger = LogManager.getLogger();
    private static final String PARAMETER_DELIMITER = "\\s+";

    public static final int MAX_SHIP_WAREHOUSE_CAPACITY = 100;

    private List<String> readShipsFile(String path){
        List<String> lines;

        try(Stream<String> stream = Files.lines(Paths.get(path))){
            lines = stream.collect(Collectors.toList());
        } catch (IOException e){
            logger.fatal("Impossible to read file: " + path, e);
            throw new RuntimeException("File can't be read.", e);
        }

        return lines;
    }

    public List<Ship> shipsFromFile(String path){
        List<String> fileLines = readShipsFile(path);
        List<Ship> ships = new ArrayList<>();

        ShipValidator shipValidator = new ShipValidator();

        for (String line: fileLines) {
            List<String> params = new ArrayList<>(Arrays.asList(line.split(PARAMETER_DELIMITER)));
            String initialContainers = params.remove(0);

            boolean validateInitial = false;
            try {
                validateInitial = shipValidator.validateInitialContainers(initialContainers);
            } catch (PortException e) {
                logger.warn(e.getMessage(), e);
            }

            if (validateInitial){
                int warehouseContainers = Integer.parseInt(initialContainers);
                var warehouse = WarehouseCreator.createWarehouse(warehouseContainers, MAX_SHIP_WAREHOUSE_CAPACITY);

                List<Integer> operations = readOperations(params);

                Ship ship = new Ship(warehouse);
                ship.setShipOperations(operations);

                ships.add(ship);
            }
        }

        return ships;
    }

    private List<Integer> readOperations(List<String> params){
        List<Integer> operations = new ArrayList<>();

        for (String param: params) {
            Integer operation = null;
            try{
                operation = Integer.parseInt(param);
                operations.add(operation);
            } catch (NumberFormatException e){
                logger.warn("Incorrect operation format: " + operation);
            }
        }

        return operations;
    }
}
