package edu.epam.first.action;

import edu.epam.first.entity.Point3D;
import edu.epam.first.entity.Sphere;
import org.testng.annotations.DataProvider;

public class SphereActionTestData {
    @DataProvider(name = "calculateAreaData")
    public static Object[][] calculateAreaData(){
        return new Object[][]{
                {new Sphere(new Point3D(10, 10, 10), 12), 1809.5573684677208},
                {new Sphere(new Point3D(10, 10, 10), 20.5), 5281.017250684442}
        };
    }

    @DataProvider(name = "calculateVolumeData")
    public static Object[][] calculateVolumeData(){
        return new Object[][]{
                {new Sphere(new Point3D(10, 10, 10), 12), 7238.229473870882},
                {new Sphere(new Point3D(10, 10, 10), 20.5), 36086.951213010354}
        };
    }

    @DataProvider(name = "isSphereData")
    public static Object[][] isSphereData(){
        return new Object[][]{
                {new Sphere(new Point3D(10, 10, 10), 12), true},
                {new Object(), false},
                {new Sphere(new Point3D(10, 10, 10), 0), false}
        };
    }

    @DataProvider(name = "touchOxyData")
    public static Object[][] touchOxyData(){
        return new Object[][]{
                {new Sphere(new Point3D(10, 10, 10), 10), true},
                {new Sphere(new Point3D(10, 10, 10), 11), false},
                {new Sphere(new Point3D(10, 10, 10), 9), false}
        };
    }
    @DataProvider(name = "touchOxzData")
    public static Object[][] touchOxzData(){
        return new Object[][]{
                {new Sphere(new Point3D(11, 10, 11), 10), true},
                {new Sphere(new Point3D(11, 10, 11), 11), false},
                {new Sphere(new Point3D(11, 10, 9), 9), false}
        };
    }
    @DataProvider(name = "touchOyzData")
    public static Object[][] touchOyzData(){
        return new Object[][]{
                {new Sphere(new Point3D(10, 11, 9), 10), true},
                {new Sphere(new Point3D(10, 10, 10), 11), false},
                {new Sphere(new Point3D(10, 9, 9), 9), false}
        };
    }
    @DataProvider(name = "relationOxyData")
    public static Object[][] relationOxyData(){
        return new Object[][]{
                {new Sphere(new Point3D(0, 0, 0), 10), 1},
                {new Sphere(new Point3D(0, 0, 20), 10), 0},
                {new Sphere(new Point3D(0, 0, 7), 25), 0.419422238372093}
        };
    }
    @DataProvider(name = "relationOxzData")
    public static Object[][] relationOxzData(){
        return new Object[][]{
                {new Sphere(new Point3D(0, 0, 0), 10), 1},
                {new Sphere(new Point3D(0, 20, 0), 10), 0},
                {new Sphere(new Point3D(0, 7, 0), 25), 0.419422238372093}
        };
    }
    @DataProvider(name = "relationOyzData")
    public static Object[][] relationOyzData(){
        return new Object[][]{
                {new Sphere(new Point3D(0, 0, 0), 10), 1},
                {new Sphere(new Point3D(20, 0, 0), 10), 0},
                {new Sphere(new Point3D(7, 0, 0), 25), 0.419422238372093}
        };
    }
}
