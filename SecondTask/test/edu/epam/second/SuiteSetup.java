package edu.epam.second;

import edu.epam.second.entity.impl.TextComposite;
import edu.epam.second.parser.impl.TextParser;
import edu.epam.second.reader.TextReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

public class SuiteSetup {
    private TextReader textReader;
    private TextParser textParser;
    public static String text;
    public static TextComposite textComposite;

    @BeforeSuite
    public void suiteSetup(){
        textReader = new TextReader();
        textParser = new TextParser();
        text = textReader.fileToString("./data/input.txt");
        textComposite = textParser.parseTextPart(text);
    }

    @AfterClass
    public void tearDown(){
        textReader = null;
    }
}
