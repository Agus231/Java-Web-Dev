package edu.epam.first.reader.validator;

import org.testng.Assert;
import org.testng.annotations.*;

public class SphereValidatorTest {

    private SphereValidator sphereValidator;
    @BeforeClass
    public void setUp() {
        sphereValidator = new SphereValidator();
    }

    @Test(dataProvider = "validateLineData", dataProviderClass = SphereValidatorTestData.class)
    public void testValidateLine(String line, boolean expected) {
        boolean actual = sphereValidator.validateLine(line);
        Assert.assertEquals(actual, expected);
    }

    @AfterClass
    public void tearDown() {
        sphereValidator = null;
    }
}