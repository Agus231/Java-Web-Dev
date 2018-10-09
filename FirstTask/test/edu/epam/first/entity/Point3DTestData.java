package edu.epam.first.entity;

import org.testng.annotations.DataProvider;

public class Point3DTestData {
    @DataProvider(name = "equalsPositiveData")
    public static Object[][] equalsPositiveData(){
        return new Object[][]{
                {new Point3D(1, 1, 1), new Point3D(1, 1, 1), true}
        };
    }

    @DataProvider(name = "equalsNegativeData")
    public static Object[][] equalsNegativeData(){
        return new Object[][]{
                {new Point3D(1, 1, 1), new Point3D(0, 1, 1), false},
                {new Point3D(1, 1, 1), new Point3D(1, 0, 1), false},
                {new Point3D(1, 1, 1), new Point3D(1, 1, 0), false},
                {new Point3D(1, 1, 1), new Point3D(0, 0, 1), false},
                {new Point3D(1, 1, 1), new Point3D(1, 0, 0), false},
                {new Point3D(1, 1, 1), new Point3D(0, 1, 0), false},
                {new Point3D(1, 1, 1), new Point3D(0, 0, 0), false}
        };
    }

    @DataProvider(name = "hashCodeData")
    public static Object[][] hashCodeData(){
        return new Object[][]{
                {new Point3D(1, 10, -12.5)},
                {new Point3D(1, -1, 1)},
                {new Point3D(-12, 12, 12)}
        };
    }
}
