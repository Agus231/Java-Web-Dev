package edu.epam.first.reader.parser;

import edu.epam.first.entity.Sphere;
import org.testng.annotations.DataProvider;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SphereParserTestData {
    @DataProvider(name = "parseLinesData")
    public static Object[][] parseLinesData(){
        return new Object[][]{
                {
                    "./data/input.txt",
                    Stream.of(new Sphere("10 10 10 10"),
                              new Sphere("10.5 10 10 10"),
                              new Sphere("10 10.5 10 10"),
                              new Sphere("10 10 10.5 10"),
                              new Sphere("10.5 10.7 10.9 10"),
                              new Sphere("-10.45 10 -10.5 15"),
                              new Sphere("10.34e+01 -20.4789E+03 10564.5e-3 20.6")).collect(Collectors.toList())
                }
        };
    }
}
