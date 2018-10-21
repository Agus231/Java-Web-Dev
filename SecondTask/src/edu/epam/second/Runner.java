package edu.epam.second;

import edu.epam.second.action.TextAction;
import edu.epam.second.entity.impl.TextComposite;
import edu.epam.second.parser.impl.TextParser;
import edu.epam.second.reader.TextReader;

public class Runner {
    public static void main(String[] args) {
        TextReader textReader = new TextReader();
        String fileText = textReader.fileToString("./data/input.txt");
        TextParser parser = new TextParser();
        TextComposite text = parser.parseTextPart(fileText);
        System.out.println(text.operation());

        TextAction textAction = new TextAction();
        /*TextComposite sortedText = textAction.sortParagraphs(text);
        System.out.println(sortedText.operation());*/
        /*TextComposite sortedByWords = textAction.sortWords(text);
        System.out.println(sortedByWords.operation());*/
        TextComposite sortedByLexems = textAction.sortLexems(text, 'e');
        System.out.println(sortedByLexems.operation());
    }
}
