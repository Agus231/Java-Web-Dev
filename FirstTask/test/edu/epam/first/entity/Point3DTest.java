package edu.epam.first.entity;

import org.testng.Assert;
import org.testng.annotations.*;

public class Point3DTest {

    @Test(dataProvider = "equalsPositiveData", dataProviderClass = Point3DTestData.class)
    public void testEqualsPositive(Point3D firstPoint, Point3D secondPoint, boolean expected){
        boolean actual = firstPoint.equals(secondPoint);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "equalsNegativeData", dataProviderClass = Point3DTestData.class)
    public void testEqualsNegative(Point3D firstPoint, Point3D secondPoint, boolean expected){
        boolean actual = firstPoint.equals(secondPoint);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "hashCodeData", dataProviderClass = Point3DTestData.class)
    public void testHashCode(Point3D point){
        int actual = point.hashCode();
        int expected = (int) ((point.getX() * 31 + point.getY() * 67 + point.getZ() * 153) % 137);
        Assert.assertEquals(actual, expected);
    }
}