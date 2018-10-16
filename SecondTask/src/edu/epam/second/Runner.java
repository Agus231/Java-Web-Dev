package edu.epam.second;

public class Runner {
    public static void main(String[] args) {
        final String PUNCTUATION_REGEX = "[\\p{Punct}\\u2026]";
        final String NUMERIC_REGEX = "\\p{Nd}";
        String EXPRESSION_REGEX = "(" + PUNCTUATION_REGEX + "*" + NUMERIC_REGEX + "+" + PUNCTUATION_REGEX + "*)+";
        System.out.println("12".matches(EXPRESSION_REGEX));
    }
}
