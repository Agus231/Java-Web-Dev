package edu.epam.first.repository;

import edu.epam.first.entity.Sphere;
import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SphereRepositoryTestData {
    private static List<Sphere> list = Stream.of(
            new Sphere(10, 10, 10, 10),
            new Sphere(5, 5, 5, 9),
            new Sphere(15, 15, 15, 11),
            new Sphere(20, 20, 20, 12),
            new Sphere(10, 10, 10, 8)).collect(Collectors.toList());
    @DataProvider(name = "sphereRepositoryDataLessRadius")
    public static Object[][] sphereRepositoryDataLessRadius(){
        return new Object[][]{
                {
                        10,
                        list,
                        Stream.of(
                                list.get(1),
                                list.get(4)).collect(Collectors.toList())
                }
        };
    }

    @DataProvider(name = "sphereRepositoryDataMoreRadius")
    public static Object[][] sphereRepositoryDataMoreRadius(){
        return new Object[][]{
                {
                        10,
                        list,
                        Stream.of(
                                list.get(2),
                                list.get(3)).collect(Collectors.toList())
                }
        };
    }

    @DataProvider(name = "sphereRepositoryDataBetweenArea")
    public static Object[][] sphereRepositoryDataBetweenArea(){
        return new Object[][]{
                {
                        1000,
                        1600,
                        list,
                        Stream.of(
                                list.get(0),
                                list.get(1),
                                list.get(2)).collect(Collectors.toList())
                }
        };
    }
}
