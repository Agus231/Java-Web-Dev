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

        var actual = new ArrayList<Boolean>();
        for (int i = 0; i < queryList.size(); i++) {
            actual.add(queryList.get(i).equalsSphere(expectedSpheres.get(i)));
        }

        var expected = new ArrayList<>(Arrays.asList(new Boolean[expectedSpheres.size()]));
        Collections.fill(expected, Boolean.TRUE);

        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "sphereRepositoryDataMoreRadius", dataProviderClass = SphereRepositoryTestData.class)
    public void testMoreRadius(double minRadius, List<Sphere> spheres, List<Sphere> expectedSpheres){
        repository.setSpheres(spheres);
        List<Sphere> queryList = repository.query(new SphereSpecificationRadiusMore(minRadius));

        var actual = new ArrayList<Boolean>();
        for (int i = 0; i < queryList.size(); i++) {
            actual.add(queryList.get(i).equalsSphere(expectedSpheres.get(i)));
        }

        var expected = new ArrayList<>(Arrays.asList(new Boolean[expectedSpheres.size()]));
        Collections.fill(expected, Boolean.TRUE);

        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "sphereRepositoryDataBetweenArea", dataProviderClass = SphereRepositoryTestData.class)
    public void testAreaBetween(double minArea, double maxArea, List<Sphere> spheres, List<Sphere> expectedSpheres){
        repository.setSpheres(spheres);
        repository.registerRepository();

        List<Sphere> queryList = repository.query(new SphereSpecificationAreaBetween(minArea, maxArea));

        var actual = new ArrayList<Boolean>();
        for (int i = 0; i < queryList.size(); i++) {
            actual.add(queryList.get(i).equalsSphere(expectedSpheres.get(i)));
        }

        var expected = new ArrayList<>(Arrays.asList(new Boolean[expectedSpheres.size()]));
        Collections.fill(expected, Boolean.TRUE);

        Assert.assertEquals(expected, actual);
    }

    @AfterClass
    public void tearDown(){
        repository.clearRepository();
        repository = null;
        registrator.unregisterSpheres();
    }
}
