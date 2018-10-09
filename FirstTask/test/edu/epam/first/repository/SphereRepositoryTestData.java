package edu.epam.first.repository;

import edu.epam.first.entity.Sphere;
import org.testng.annotations.DataProvider;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SphereRepositoryTestData {
    @DataProvider(name = "sphereRepositoryDataLessRadius")
    public static Object[][] sphereRepositoryDataLessRadius(){
        return new Object[][]{
                {
                        10,
                        Stream.of(
                                new Sphere(10, 10, 10, 10),
                                new Sphere(5, 5, 5, 9),
                                new Sphere(15, 15, 15, 11),
                                new Sphere(20, 20, 20, 12),
                                new Sphere(10, 10, 10, 8)).collect(Collectors.toList()),
                        Stream.of(
                                new Sphere(5, 5, 5, 9),
                                new Sphere(10, 10, 10, 8)).collect(Collectors.toList())
                }
        };
    }

    @DataProvider(name = "sphereRepositoryDataMoreRadius")
    public static Object[][] sphereRepositoryDataMoreRadius(){
        return new Object[][]{
                {
                        10,
                        Stream.of(
                                new Sphere(10, 10, 10, 10),
                                new Sphere(5, 5, 5, 9),
                                new Sphere(15, 15, 15, 11),
                                new Sphere(20, 20, 20, 12),
                                new Sphere(10, 10, 10, 8)).collect(Collectors.toList()),
                        Stream.of(
                                new Sphere(15, 15, 15, 11),
                                new Sphere(20, 20, 20, 12)).collect(Collectors.toList())
                }
        };
    }

    @DataProvider(name = "sphereRepositoryDataBetweenArea")
    public static Object[][] sphereRepositoryDataBetweenArea(){
        return new Object[][]{
                {
                        1000,
                        1600,
                        Stream.of(
                                new Sphere(10, 10, 10, 10),
                                new Sphere(5, 5, 5, 9),
                                new Sphere(15, 15, 15, 11),
                                new Sphere(20, 20, 20, 12),
                                new Sphere(10, 10, 10, 8)).collect(Collectors.toList()),
                        Stream.of(
                                new Sphere(10, 10, 10, 10),
                                new Sphere(5, 5, 5, 9),
                                new Sphere(15, 15, 15, 11)).collect(Collectors.toList())
                }
        };
    }
}
