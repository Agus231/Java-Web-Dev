package edu.epam.first.action;

import edu.epam.first.entity.Sphere;
import edu.epam.first.exception.SphereException;
import org.testng.Assert;
import org.testng.annotations.*;

public class SphereActionTest {

    private SphereAction sphereAction;

    @BeforeClass
    public void setUp() {
        sphereAction = SphereAction.getInstance();
    }

    @Test(dataProvider = "calculateVolumeData", dataProviderClass = SphereActionTestData.class)
    public void testCalculateVolume(Sphere sphere, double expected) {
        double actual = sphereAction.calculateVolume(sphere);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "calculateAreaData", dataProviderClass = SphereActionTestData.class)
    public void testCalculateArea(Sphere sphere, double expected) {
        double actual = sphereAction.calculateArea(sphere);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "isSphereData", dataProviderClass = SphereActionTestData.class)
    public void testIsSphere(Object object, boolean expected) {
        boolean actual = sphereAction.isSphere(object);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "touchOxyData", dataProviderClass = SphereActionTestData.class)
    public void testDoTouchOxy(Sphere sphere, boolean expected) {
        boolean actual = sphereAction.doTouchOxy(sphere);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "touchOxzData", dataProviderClass = SphereActionTestData.class)
    public void testDoTouchOxz(Sphere sphere, boolean expected) {
        boolean actual = sphereAction.doTouchOxz(sphere);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "touchOyzData", dataProviderClass = SphereActionTestData.class)
    public void testDoTouchOyz(Sphere sphere, boolean expected) {
        boolean actual = sphereAction.doTouchOyz(sphere);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "relationOxyData", dataProviderClass = SphereActionTestData.class)
    public void testRelationOxy(Sphere sphere, double expected) throws SphereException {
        double actual = sphereAction.relationOxy(sphere);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "relationOxzData", dataProviderClass = SphereActionTestData.class)
    public void testRelationOxz(Sphere sphere, double expected) throws SphereException {
        double actual = sphereAction.relationOxz(sphere);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "relationOyzData", dataProviderClass = SphereActionTestData.class)
    public void testRelationOyz(Sphere sphere, double expected) throws SphereException {
        double actual = sphereAction.relationOyz(sphere);
        Assert.assertEquals(actual, expected);
    }

    @AfterClass
    public void tearDown() {
        sphereAction = null;
    }
}