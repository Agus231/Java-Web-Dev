package edu.epam.first.reader.parser;

import edu.epam.first.entity.Sphere;
import edu.epam.first.reader.SphereFileReader;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class SphereParserTest {
    private SphereParser sphereParser;

    @BeforeClass
    public void setUp(){
        sphereParser = new SphereParser();
    }

    @Test(dataProvider = "parseLinesData", dataProviderClass = SphereParserTestData.class)
    public void testParseLines(String path, List<Sphere> expectedList) {
        SphereFileReader sphereFileReader = new SphereFileReader();
        List<Sphere> actualList = sphereParser.parseLines(sphereFileReader.readAll(path));

        Assert.assertEquals(actualList.size(), expectedList.size());
    }

    @AfterClass
    public void tearDown(){
        sphereParser = null;
    }
}