package edu.epam.first.entity;

import org.testng.Assert;
import org.testng.annotations.*;

public class SphereTest {

    @Test(dataProvider = "equalsData", dataProviderClass = SphereTestData.class)
    public void testEquals(Sphere firstSphere, Sphere secondSphere, boolean expected) {
        boolean actual = firstSphere.equals(secondSphere);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "equalsSphereData", dataProviderClass = SphereTestData.class)
    public void testEqualsSphere(Sphere firstSphere, Sphere secondSphere, boolean expected) {
        boolean actual = firstSphere.equalsSphere(secondSphere);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "hashCodeData", dataProviderClass = SphereTestData.class)
    public void testHashCode(Sphere sphere) {
        int actual = sphere.hashCode();
        int expected = (int)((sphere.getSphereId() + sphere.getCenter().hashCode() + sphere.getRadius() * 41) % 57);
        Assert.assertEquals(actual, expected);
    }

}