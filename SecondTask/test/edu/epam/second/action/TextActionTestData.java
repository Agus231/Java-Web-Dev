package edu.epam.second.action;

import edu.epam.second.SuiteSetup;
import edu.epam.second.entity.impl.TextComposite;
import edu.epam.second.parser.impl.TextParser;
import edu.epam.second.reader.TextReader;
import org.testng.annotations.DataProvider;

public class TextActionTestData {
    private static TextParser parser = new TextParser();
    private static TextReader reader = new TextReader();

    @DataProvider(name = "dataTextActionSortParagraphs")
    public static Object[][] dataTextActionSortParagraphs(){
        TextComposite textCompositeSortByParagraph = parser.parseTextPart(reader.fileToString("./data/testSortParagraphs.txt"));

        return new Object[][]{
                {SuiteSetup.textComposite, textCompositeSortByParagraph}
        };
    }

    @DataProvider(name="dataTextActionSortWords")
    public static Object[][] dataTextActionSortWords(){
        TextComposite textCompositeSortByWords = parser.parseTextPart(reader.fileToString("./data/testSortWords.txt"));

        return new Object[][]{
                {SuiteSetup.textComposite, textCompositeSortByWords}
        };
    }

    @DataProvider(name="dataTextActionSortLexicalUnits")
    public static Object[][] dataTextActionSortLexicalUnits(){
        TextComposite textCompositeSortByLexicalUnits = parser.parseTextPart(reader.fileToString("./data/testSortLexicalUnits.txt"));

        return new Object[][]{
                {SuiteSetup.textComposite, textCompositeSortByLexicalUnits}
        };
    }
}
