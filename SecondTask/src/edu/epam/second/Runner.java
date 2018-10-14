package edu.epam.second;

import edu.epam.second.action.WordAction;
import edu.epam.second.entity.Text;
import edu.epam.second.entity.Word;
import edu.epam.second.localiztion.ResourceManager;
import edu.epam.second.parser.TextParser;
import edu.epam.second.reader.TextReader;

import java.util.List;
import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        ResourceManager manager = ResourceManager.INSTANCE;
        //Locale locale = new Locale("en", "US");
        //manager.changeResource(locale);
        TextReader textReader = new TextReader();
        TextParser textParser = new TextParser();

        String text = textReader.readFileToString("./data/input.txt");
        Text textObj = textParser.handleParse(text);

        System.out.println(manager.getString(ResourceManager.TEXT_KEY)); //localization
        textObj.operation();

        List<Word> wordList = textObj.wordList();
        System.out.println(manager.getString(ResourceManager.FIRST_SORT_KEY)); //localization
        wordList.stream().sorted(WordAction.comparatorFirst).forEach(System.out::println);
        System.out.println();

        System.out.println(manager.getString(ResourceManager.SECOND_SORT_KEY)); //localization
        wordList.stream().filter(word -> {
            char[] characters = word.getValue().toCharArray();
            return WordAction.isVovel(String.valueOf(characters[0])) && characters.length != 1;
        }).sorted(WordAction.comparatorSecond).forEach(System.out::println);
    }
}
