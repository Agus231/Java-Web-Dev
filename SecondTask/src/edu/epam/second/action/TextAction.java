package edu.epam.second.action;

import edu.epam.second.entity.TextComponent;
import edu.epam.second.entity.impl.LexicalUnitComposite;
import edu.epam.second.entity.impl.ParagraphComposite;
import edu.epam.second.entity.impl.SentenceComposite;
import edu.epam.second.entity.impl.TextComposite;
import edu.epam.second.entity.type.ComponentType;
import edu.epam.second.exception.TextException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TextAction {
    private static final TextAction INSTANCE = new TextAction();
    private TextAction(){}

    public static TextAction getInstance(){
        return INSTANCE;
    }

    public TextComposite sortParagraphs(TextComposite text) throws TextException {
        TextComposite clone;
        try {
            clone = text.clone();
            List<ParagraphComposite> paragraphs = clone.getComponents();
            paragraphs.sort(Comparator.comparingInt(s -> s.getComponents().size()));
        } catch (CloneNotSupportedException e) {
            throw new TextException("Exception while cloning object : " + text, e);
        }
        return clone;
    }

    public TextComposite sortWords(TextComposite text) throws TextException {
        TextComposite clone;
        try {
            clone = text.clone();
            List<TextComponent> word = new ArrayList<>();
            List<ParagraphComposite> paragraphs = clone.getComponents();

            for (ParagraphComposite paragraph : paragraphs) {
                for (SentenceComposite sentence : paragraph.getComponents()) {
                    for (LexicalUnitComposite unitComposite : sentence.getComponents()) {
                        for (TextComponent unitElement : unitComposite.getComponents()) {
                            if (unitElement.getComponentType() == ComponentType.WORD) {
                                word.add(unitElement);
                            }
                        }
                    }
                    word.sort(Comparator.comparingInt(s -> s.getComponents().size()));
                    for (LexicalUnitComposite anUnitComposite : sentence.getComponents()) {
                        List<TextComponent> unitElements = anUnitComposite.getComponents();
                        for (int m = 0; m < unitElements.size(); m++) {
                            if (unitElements.get(m).getComponentType() == ComponentType.WORD) {
                                unitElements.set(m, word.get(0));
                                word.remove(0);
                            }
                        }
                    }
                }
            }

        } catch (CloneNotSupportedException e) {
            throw new TextException("Exception while cloning object : " + text, e);
        }
        return clone;
    }

    public TextComposite sortLicalUnits(TextComposite text, Character symbol) throws TextException {
        Comparator<LexicalUnitComposite> comparatorByOccurrencesCount = (s1, s2) -> {
            String lexem1 = s1.operation();
            String lexem2 = s2.operation();

            long occurrencesCount1 = lexem1.chars().filter(ch -> ch == symbol).count();
            long occurrencesCount2 = lexem2.chars().filter(ch -> ch == symbol).count();

            return Long.compare(occurrencesCount1, occurrencesCount2);
        };

        Comparator<LexicalUnitComposite> comparatorByAlphabet = Comparator.comparing(LexicalUnitComposite::operation);
        Comparator<LexicalUnitComposite> compositeComparator = comparatorByOccurrencesCount.thenComparing(comparatorByAlphabet);

        TextComposite clone;
        try {
            clone = text.clone();
            List<ParagraphComposite> paragraphs = clone.getComponents();

            for (ParagraphComposite paragraph : paragraphs) {
                for (SentenceComposite sentence : paragraph.getComponents()) {
                    List<LexicalUnitComposite> units = sentence.getComponents();
                    units.sort(compositeComparator);
                }
            }
        } catch (CloneNotSupportedException e) {
            throw new TextException("Exception while cloning object : " + text, e);
        }

        return clone;
    }
}
