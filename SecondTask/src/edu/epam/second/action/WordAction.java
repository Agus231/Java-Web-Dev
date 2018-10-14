package edu.epam.second.action;

import edu.epam.second.entity.Word;

import java.util.Comparator;

public class WordAction {
    private static final String LETTER_REGEX = "[ауеёоыяиюэАУЕЁОЫЯИЮЭaeuiojAEUIOJ]";

    public static Comparator<Word> comparatorFirst = ((o1, o2) -> {
        var wordFirst = o1.getValue();
        var worSecond = o2.getValue();

        return Double.compare(correlation(wordFirst), correlation(worSecond));
    });

    public static Comparator<Word> comparatorSecond = ((o1, o2) -> {
        var wordFirst = o1.getValue();
        var worSecond = o2.getValue();

        var agreeable1 = getFirstAgreeable(wordFirst);
        var agreeable2 = getFirstAgreeable(worSecond);

        return agreeable1.compareTo(agreeable2);
    });

    private static double correlation(String word){
        char[] firstWordSymbols = word.toCharArray();

        double vovel = 0;
        double agreeable = 0;

        for (char c: firstWordSymbols) {
            String character = String.valueOf(c);
            if (character.matches(LETTER_REGEX)){
                vovel++;
            }
            else {
                agreeable++;
            }
        }
        return vovel / agreeable;
    }

    private static String getFirstAgreeable(String word){
        char[] firstWordSymbols = word.toCharArray();

        for (char c: firstWordSymbols) {
            String character = String.valueOf(c);
            if (!character.matches(LETTER_REGEX)) {
                return character;
            }
        }
        return "";
    }

    public static boolean isVovel(String c){
        return c.matches(LETTER_REGEX);
    }
}
