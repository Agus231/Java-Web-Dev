package edu.epam.first.sort;

import edu.epam.first.entity.Sphere;
import org.testng.annotations.DataProvider;

import java.util.List;

public class SphereSortTestData {
    @DataProvider(name = "sphereSortDataRadius")
    public static Object[][] sphereSortDataRadius(){
        return new Object[][]{
                {
                    List.of(new Sphere(10, 10, 10, 10),
                            new Sphere(5, 5, 5, 9),
                            new Sphere(15, 15, 15, 11),
                            new Sphere(20, 20, 20, 12),
                            new Sphere(10, 10, 10, 8)
                            ),
                    List.of(new Sphere(10, 10, 10, 8),
                            new Sphere(5, 5, 5, 9),
                            new Sphere(10, 10, 10, 10),
                            new Sphere(15, 15, 15, 11),
                            new Sphere(20, 20, 20, 12)
                            )
                }
        };
    }
}
