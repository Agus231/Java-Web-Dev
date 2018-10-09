package edu.epam.first.reader.parser;

import edu.epam.first.entity.Point3D;
import edu.epam.first.entity.Sphere;
import edu.epam.first.reader.validator.SphereValidator;

import java.util.ArrayList;
import java.util.List;

public class SphereParser {
    public Sphere parseLine(String str) {
        String[] strings = str.split("\\s+");

        double x = Double.parseDouble(strings[0]);
        double y = Double.parseDouble(strings[1]);
        double z = Double.parseDouble(strings[2]);
        double radius = Double.parseDouble(strings[3]);

        return new Sphere(new Point3D(x, y, z), radius);
    }

    public List<Sphere> parseLines(List<String> listData){
        List<Sphere> spheres = new ArrayList<>();
        SphereValidator validator = new SphereValidator();

        for (String str: listData) {
            if (validator.validateLine(str)) {
                spheres.add(parseLine(str));
            }
        }
        return spheres;
    }
}
