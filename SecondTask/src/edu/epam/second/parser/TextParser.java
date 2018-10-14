package edu.epam.second.parser;

import edu.epam.second.entity.Paragraph;
import edu.epam.second.entity.Text;
import java.util.List;

public class TextParser {
    private ParagraphParser paragraphParser = new ParagraphParser();

    public Text handleParse(String text){
        return concatParagraphs(paragraphParser.handleParse(text));
    }

    private Text concatParagraphs(List<Paragraph> paragraphs){
        var text = new Text();
        text.addAll(paragraphs);
        return text;
    }
}
