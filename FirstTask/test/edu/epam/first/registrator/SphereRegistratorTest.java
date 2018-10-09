package edu.epam.first.registrator;

import edu.epam.first.entity.Sphere;
import edu.epam.first.observer.SphereObserver;
import edu.epam.first.repository.SphereRepository;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class SphereRegistratorTest {
    private SphereRepository repository;
    private Registrator registrator;

    @BeforeClass
    public void setUp(){
        repository = new SphereRepository();
        registrator =  Registrator.getInstance();
    }

    @Test(dataProvider = "sphereRegistratorData", dataProviderClass = SphereRegistratorTestData.class)
    public void testObserverWithoutEvent(List<Sphere> spheres, Sphere newSphere, Sphere expectedSphere){
        repository.setSpheres(spheres);
        repository.registerRepository();

        SphereObserver observer = new SphereObserver();
        newSphere.attachObserver(observer);

        repository.add(newSphere);
        repository.add(expectedSphere);


        Assert.assertNotEquals(registrator.getParameters(newSphere), registrator.getParameters(expectedSphere));
    }

    @Test(dataProvider = "sphereRegistratorData", dataProviderClass = SphereRegistratorTestData.class)
    public void testObserverWithEvent(List<Sphere> spheres, Sphere newSphere, Sphere expectedSphere){
        repository.setSpheres(spheres);
        repository.registerRepository();

        SphereObserver observer = new SphereObserver();
        newSphere.attachObserver(observer);

        repository.add(newSphere);
        repository.add(expectedSphere);
        newSphere.setRadius(expectedSphere.getRadius());

        Assert.assertEquals(registrator.getParameters(newSphere), registrator.getParameters(expectedSphere));
    }

    @AfterClass
    public void tearDown(){
        repository.clearRepository();
        repository = null;
        registrator.unregisterSpheres();
    }
}
