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
        repository = new SphereRepository();
    }

    @Test(dataProvider = "sphereSortDataRadius", dataProviderClass = SphereSortTestData.class)
    public void testSortByRadius(List<Sphere> listToSort, List<Sphere> expectedList){
        repository.setSpheres(listToSort);

        List<Sphere> sortedSpheres = repository.sort(Comparator.comparingDouble(Sphere::getRadius));
        List<Boolean> actual = new ArrayList<>();

        for (int i = 0; i < sortedSpheres.size(); i++) {
            actual.add(sortedSpheres.get(i).equalsSphere(expectedList.get(i)));
        }

        List<Boolean> expected = new ArrayList<>(Arrays.asList(new Boolean[sortedSpheres.size()]));
        Collections.fill(expected, Boolean.TRUE);

        repository.clearRepository();
        Assert.assertEquals(actual, expected);
    }

    @AfterClass
    public void tearDown(){
        repository = null;
    }
}
