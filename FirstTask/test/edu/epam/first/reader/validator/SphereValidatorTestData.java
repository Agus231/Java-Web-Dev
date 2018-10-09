package edu.epam.first.reader.validator;

import org.testng.annotations.DataProvider;

public class SphereValidatorTestData {
    @DataProvider(name = "validateLineData")
    public static Object[][] validateLineData(){
        return new Object[][]{
                {"12.3 12.7 23.8 20.5", true},
                {"12 12 23 20", true},
                {"-12 +12.4 -23.7 20", true},
                {"12.3 -12 23 -20", false},
                {"12.3 12 23 20", true},
                {"3.14E+00 1.048e+02 10 27 ", true}
        };
    }
}
