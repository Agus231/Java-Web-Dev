package edu.epam.second.parser;

import edu.epam.second.entity.TextComponent;

public interface BaseParser {
    //splitting regex:
    String PARAGRAPH_SPLIT_REGEX = "(?m)(?=^\\s{4})";
    String SENTENCE_SPLIT_REGEX = "(?<=[.!?\\u2026])";
    String LEXICAL_UNIT_SPLIT_REGEX = "\\p{Blank}+";

    //lexical unit identity regex:
    String PUNCTUATION_REGEX = "[\\p{Punct}\\u2026]";
    String LETTER_REGEX = "\\p{L}";

    String WORD_REGEX = LETTER_REGEX + "+";
    String WORD_WITH_PUNCT_ENDS = WORD_REGEX + PUNCTUATION_REGEX;
    String WORD_WITH_PUNCT_BEGINS_ENDS = PUNCTUATION_REGEX + WORD_WITH_PUNCT_ENDS;

    String NUMERIC_REGEX = "\\p{Nd}";
    String NUMBER_REGEX = NUMERIC_REGEX + "+";

    String EXPRESSION_REGEX = "(" + PUNCTUATION_REGEX + "*" + NUMERIC_REGEX + "+" + PUNCTUATION_REGEX + "*)+";

    //expression splitting regex:
    String UNSIGNED_SHIFT_REGEX = "(>){3}";
    String UNSIGNED_SHIFT_SPLIT_REGEX = "(?<=(" + UNSIGNED_SHIFT_REGEX + "))|(?=(" + UNSIGNED_SHIFT_REGEX + "))";
    String EXPRESSION_SPLIT_REGEX = "(?<=((>){2}|(<){2}|(&)|(\\^)|(~)|(\\|)|\\(|\\)))|(?=((>){2}|(<){2}|(&)|(\\^)|(~)|(\\|)|\\(|\\)))";

    TextComponent parseTextPart(String text);
}
