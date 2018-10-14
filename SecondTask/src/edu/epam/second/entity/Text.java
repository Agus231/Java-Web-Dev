package edu.epam.second.entity;

import edu.epam.second.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Text implements Component<Paragraph> {
    private List<Paragraph> paragraphs = new ArrayList<>();
    @Override
    public void operation() {
        paragraphs.forEach(Component::operation);
    }

    @Override
    public boolean add(Paragraph component) {
        return paragraphs.add(component);
    }

    @Override
    public boolean addAll(List<Paragraph> component) {
        return paragraphs.addAll(component);
    }

    @Override
    public boolean remove(Paragraph component) {
        return paragraphs.add(component);
    }

    @Override
    public String toString() {
        return "Text{" +
                "paragraphs=" + paragraphs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Text text = (Text) o;
        return Objects.equals(paragraphs, text.paragraphs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paragraphs);
    }

    public List<Word> wordList(){
        List<Word> words = new ArrayList<>();
        for (Paragraph p: paragraphs) {
            List<Sentence> sentences = p.getSentences();
            for (Sentence s: sentences) {
                List<LexicalToken> tokens = s.getTokens();
                for (LexicalToken lexem: tokens) {
                    var word = lexem.getWordFromLexem();
                    if (word != null) {
                        words.add(word);
                    }
                }
            }
        }
        return words;
    }
}
