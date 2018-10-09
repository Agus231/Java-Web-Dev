package edu.epam.first.registrator;

import edu.epam.first.entity.Sphere;
import org.testng.annotations.DataProvider;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SphereRegistratorTestData {
    @DataProvider(name = "sphereRegistratorData")
    public static Object[][] sphereRegistratorData(){
        return new Object[][]{
            {
                    Stream.of(
                            new Sphere(10, 10, 10, 10),
                            new Sphere(5, 5, 5, 9),
                            new Sphere(15, 15, 15, 11),
                            new Sphere(20, 20, 20, 12),
                            new Sphere(10, 10, 10, 8)).collect(Collectors.toList()),
                    new Sphere(15, 10, 5, 5),
                    new Sphere(15, 10, 18, 18)
            }
        };
    }
}
