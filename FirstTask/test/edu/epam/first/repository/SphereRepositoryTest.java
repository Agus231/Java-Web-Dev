package edu.epam.first.repository;

import edu.epam.first.action.SphereAction;
import edu.epam.first.entity.Sphere;
import edu.epam.first.observer.SphereObserver;
import edu.epam.first.registrator.Registrator;
import edu.epam.first.registrator.SphereRegistratorTestData;
import edu.epam.first.repository.specification.SphereSpecificationAreaBetween;
import edu.epam.first.repository.specification.SphereSpecificationRadiusLess;
import edu.epam.first.repository.specification.SphereSpecificationRadiusMore;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SphereRepositoryTest {
    private SphereRepository repository;
    private Registrator registrator;

    @BeforeClass
    public void setUp(){
        repository = new SphereRepository();
        registrator =  Registrator.getInstance();
    }

    @Test(dataProvider = "sphereRepositoryDataLessRadius", dataProviderClass = SphereRepositoryTestData.class)
    public void testLessRadius(double maxRadius, List<Sphere> spheres, List<Sphere> expectedSpheres){
        repository.setSpheres(spheres);
        List<Sphere> queryList = repository.query(new SphereSpecificationRadiusLess(maxRadius));

        Assert.assertEquals(queryList, expectedSpheres);
    }

    @Test(dataProvider = "sphereRepositoryDataMoreRadius", dataProviderClass = SphereRepositoryTestData.class)
    public void testMoreRadius(double minRadius, List<Sphere> spheres, List<Sphere> expectedSpheres){
        repository.setSpheres(spheres);
        List<Sphere> queryList = repository.query(new SphereSpecificationRadiusMore(minRadius));

        Assert.assertEquals(queryList, expectedSpheres);
    }

    @Test(dataProvider = "sphereRepositoryDataBetweenArea", dataProviderClass = SphereRepositoryTestData.class)
    public void testAreaBetween(double minArea, double maxArea, List<Sphere> spheres, List<Sphere> expectedSpheres){
        repository.setSpheres(spheres);
        repository.registerRepository();

        List<Sphere> queryList = repository.query(new SphereSpecificationAreaBetween(minArea, maxArea));

        Assert.assertEquals(queryList, expectedSpheres);
    }

    @AfterClass
    public void tearDown(){
        repository.clearRepository();
        repository = null;
        registrator.unregisterSpheres();
    }
}
