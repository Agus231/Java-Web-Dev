package edu.epam.first.entity;

import org.testng.annotations.DataProvider;

public class SphereTestData {
    @DataProvider(name = "equalsData")
    public static Object[][] equalsData(){
        return new Object[][]{
                {new Sphere("12 12 12 20"), new Sphere(new Point3D(12, 12, 12), 20), false},
        };
    }

    @DataProvider(name = "equalsSphereData")
    public static Object[][] equalsSphereData(){
        return new Object[][]{
                {new Sphere("12 12 12 20"), new Sphere(new Point3D(12, 12, 12), 20), true},
                {new Sphere("10 12 13 20"), new Sphere("10 12 13 20"), true},
                {new Sphere(new Point3D(10, 10, 15), 20), new Sphere("10 10 15 20"), true},
                {new Sphere(new Point3D(15, 15, 15), 20), new Sphere(new Point3D(15, 15, 15), 20), true},
                {new Sphere(new Point3D(15, 15, 15), 20), new Sphere(new Point3D(10, 15, 15), 20), false},
                {new Sphere(new Point3D(15, 15, 15), 20), new Sphere(new Point3D(15, 10, 15), 20), false},
                {new Sphere(new Point3D(15, 15, 15), 20), new Sphere(new Point3D(15, 15, 10), 20), false},
                {new Sphere(new Point3D(15, 15, 15), 20), new Sphere(new Point3D(15, 15, 15), 10), false}
        };
    }

    @DataProvider(name = "hashCodeData")
    public static Object[][] hashCodeData(){
        return new Object[][]{
                {new Sphere(new Point3D(12, -12, 10), 20)},
                {new Sphere(new Point3D(10.9, -10.5, 10.7), 25.5)},
                {new Sphere(new Point3D(-17.9, 12.4, 1100.5), 220.3)}
        };
    }
}
