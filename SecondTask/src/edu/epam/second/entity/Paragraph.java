package edu.epam.second.entity;

import edu.epam.second.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Paragraph implements Component<Sentence> {
    private List<Sentence> sentences = new ArrayList<>();

    @Override
    public void operation() {
        System.out.print('\t');
        sentences.forEach(Component::operation);
        System.out.println();
    }

    @Override
    public boolean add(Sentence component) {
        return sentences.add(component);
    }

    @Override
    public boolean addAll(List<Sentence> component) {
        return sentences.addAll(component);
    }

    @Override
    public boolean remove(Sentence component) {
        return sentences.remove(component);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }

        if (o == null || getClass() != o.getClass()){
            return false;
        }

        Paragraph paragraph = (Paragraph) o;
        return Objects.equals(sentences, paragraph.sentences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentences);
    }


    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        return "Paragraph{" +
                "sentences=" + sentences +
                '}';
    }
}
