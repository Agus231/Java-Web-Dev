package edu.epam.first.registrator;

import edu.epam.first.entity.Sphere;
import edu.epam.first.exception.SphereException;
import edu.epam.first.observer.SphereObserver;
import edu.epam.first.repository.SphereRepository;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class SphereWarehouseTest {
    private SphereRepository repository;
    private Warehouse warehouse;

    @BeforeClass
    public void setUp(){
        repository = SphereRepository.getInstance();
        warehouse =  Warehouse.getInstance();
    }

    @Test(dataProvider = "sphereRegistratorData", dataProviderClass = SphereRegistratorTestData.class)
    public void testObserverWithoutEvent(Sphere newSphere, Sphere expectedSphere){
        Assert.assertNotEquals(warehouse.getParameters(newSphere), warehouse.getParameters(expectedSphere));
    }

    @Test(dataProvider = "sphereRegistratorData", dataProviderClass = SphereRegistratorTestData.class)
    public void testObserverWithEvent(Sphere newSphere, Sphere expectedSphere){
        newSphere.setRadius(expectedSphere.getRadius());
        Assert.assertEquals(warehouse.getParameters(newSphere), warehouse.getParameters(expectedSphere));
    }

    @AfterClass
    public void tearDown(){
        repository.clearRepository();
        warehouse.unregisterSpheres();
    }
}
