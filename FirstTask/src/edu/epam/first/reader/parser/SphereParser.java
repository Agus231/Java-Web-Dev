package edu.epam.first.reader.parser;

import edu.epam.first.entity.Point3D;
import edu.epam.first.entity.Sphere;
import edu.epam.first.exception.SphereException;
import edu.epam.first.reader.validator.SphereValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SphereParser {
    private static Logger logger = LogManager.getLogger();

    private Sphere parseLine(String line) throws SphereException {
        var validator = new SphereValidator();

        double x, y, z, radius;

        if (validator.validateLine(line)) {
            String[] numbers = line.split("\\s+");

            x = Double.parseDouble(numbers[0]);
            y = Double.parseDouble(numbers[1]);
            z = Double.parseDouble(numbers[2]);
            radius = Double.parseDouble(numbers[3]);
        }
        else {
            throw new SphereException("Sphere from line: " + line + "; can't be created.");
        }

        return new Sphere(new Point3D(x, y, z), radius);
    }

    public List<Sphere> parseLines(List<String> listData){
        var spheres = new ArrayList<Sphere>();

        for (String line: listData) {
            try {
                spheres.add(parseLine(line));
            } catch (SphereException e) {
                logger.warn(e.getMessage(), e);
            }
        }
        return spheres;
    }
}
