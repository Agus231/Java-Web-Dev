package edu.epam.second.parser;

import edu.epam.second.Component;
import edu.epam.second.entity.Symbol;
import edu.epam.second.entity.Word;
import java.util.ArrayList;
import java.util.List;

public class SymbolParser {
    public List<Component> handleParse(String lexem){
        List<Component> components = new ArrayList<>();

        char[] charArray = lexem.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if(!Character.isLetter(charArray[i])) {
                components.add(new Symbol(charArray[i]));
            }
            else {
                StringBuilder word = new StringBuilder();
                if(components.isEmpty() || !components.get(0).equals(new Symbol('<'))) {
                    while (Character.isLetter(charArray[i])) {
                        word.append(charArray[i]);
                        i++;
                    }
                    var wordComponent = new Word(word.toString());
                    components.add(wordComponent);
                    i--;
                }
                else {
                    components.add(new Symbol(charArray[i]));
                }
            }
        }

        return components;
    }
}
