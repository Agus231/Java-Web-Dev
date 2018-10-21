package edu.epam.second;

import edu.epam.second.entity.impl.TextComposite;
import edu.epam.second.parser.impl.TextParser;
import edu.epam.second.reader.TextReader;

public class Runner {
    public static void main(String[] args) {
        TextReader textReader = new TextReader();
        String fileText = textReader.fileToString("./data/input.txt");
        TextParser parser = new TextParser();
        TextComposite text = parser.parseTextPart(fileText);
        System.out.println((71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78);
        System.out.println(text.operation());

    }
}
