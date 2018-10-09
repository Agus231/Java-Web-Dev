package edu.epam.first.reader;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class SphereFileReaderTest {
    private SphereFileReader sphereFileReader;

    @BeforeClass
    public void setUp() {
        sphereFileReader = new SphereFileReader();
    }

    @Test(expectedExceptions = {RuntimeException.class}, expectedExceptionsMessageRegExp = "File can't be read.")
    public void testExceptionReadAll() {
        String path = "./data/fileNotExists.txt";
        List<String> list = sphereFileReader.readAll(path);
    }

    @Test(dataProvider = "readAllData", dataProviderClass = SphereFileReaderTestData.class)
    public void testReadAll(String path, List<String> expected) {
        List<String> actual = sphereFileReader.readAll(path);
        Assert.assertEquals(actual, expected);
    }


    @AfterClass
    public void tearDown() {
        sphereFileReader = null;
    }
}