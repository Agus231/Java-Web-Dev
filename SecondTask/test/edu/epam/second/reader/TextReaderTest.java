package edu.epam.second.reader;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TextReaderTest {

    private TextReader textReader;

    @BeforeClass
    public void setUp(){
        textReader = new TextReader();
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testFileToStringNegative() {
        textReader.fileToString("./data/noSuchFile.txt");
    }

    @Test(dataProvider = "textReaderData", dataProviderClass = TextReaderTestData.class)
    public void testFileToStringPositive(String path, String expected) {
        String actual = textReader.fileToString(path);
        Assert.assertEquals(actual, expected);
    }


    @AfterClass
    public void tearDown(){
        textReader = null;
    }
}