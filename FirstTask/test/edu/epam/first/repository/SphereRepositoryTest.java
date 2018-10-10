package edu.epam.first.repository;

import edu.epam.first.entity.Sphere;
import edu.epam.first.registrator.Warehouse;
import edu.epam.first.repository.specification.impl.SphereAreaBetweenSpecification;
import edu.epam.first.repository.specification.impl.SphereRadiusLessSpecification;
import edu.epam.first.repository.specification.impl.SphereRadiusMoreSpecification;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class SphereRepositoryTest {
    private SphereRepository repository;
    private Warehouse warehouse;

    @BeforeClass
    public void setUp(){
        repository = new SphereRepository();
        warehouse =  Warehouse.getInstance();
    }

    @Test(dataProvider = "sphereRepositoryDataLessRadius", dataProviderClass = SphereRepositoryTestData.class)
    public void testLessRadius(double maxRadius, List<Sphere> spheres, List<Sphere> expectedSpheres){
        repository.setSpheres(spheres);
        List<Sphere> queryList = repository.query(new SphereRadiusLessSpecification(maxRadius));

        Assert.assertEquals(queryList, expectedSpheres);
    }

    @Test(dataProvider = "sphereRepositoryDataMoreRadius", dataProviderClass = SphereRepositoryTestData.class)
    public void testMoreRadius(double minRadius, List<Sphere> spheres, List<Sphere> expectedSpheres){
        repository.setSpheres(spheres);
        List<Sphere> queryList = repository.query(new SphereRadiusMoreSpecification(minRadius));

        Assert.assertEquals(queryList, expectedSpheres);
    }

    @Test(dataProvider = "sphereRepositoryDataBetweenArea", dataProviderClass = SphereRepositoryTestData.class)
    public void testAreaBetween(double minArea, double maxArea, List<Sphere> spheres, List<Sphere> expectedSpheres){
        repository.setSpheres(spheres);
        repository.registerRepository();

        List<Sphere> queryList = repository.query(new SphereAreaBetweenSpecification(minArea, maxArea));

        Assert.assertEquals(queryList, expectedSpheres);
    }

    @AfterClass
    public void tearDown(){
        repository.clearRepository();
        repository = null;
        warehouse.unregisterSpheres();
    }
}
