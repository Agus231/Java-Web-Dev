package edu.epam.first.sort;

import edu.epam.first.entity.Sphere;
import edu.epam.first.repository.SphereRepository;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

public class SphereSortTest {
    private SphereRepository repository;

    @BeforeClass
    public void setUp(){
        repository = SphereRepository.getInstance();
    }

    @Test(dataProvider = "sphereSortDataRadius", dataProviderClass = SphereSortTestData.class)
    public void testSortByRadius(List<Sphere> expectedList){
        List<Sphere> sortedSpheres = repository.sort(Comparator.comparingDouble(Sphere::getRadius));
        Assert.assertEquals(sortedSpheres, expectedList);
    }

    @AfterClass
    public void tearDown(){
        repository = null;
    }
}
