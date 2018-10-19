package edu.epam.second.parser;

import edu.epam.second.entity.TextComponent;
import edu.epam.second.entity.impl.LexicalUnitComposite;
import edu.epam.second.entity.impl.Symbol;
import edu.epam.second.entity.type.CharacterType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * … - 2026
 * all the possible lexems:
 * -
 * a
 * word,
 * word
 * (word)
 * 13<<2
 * (word),
 */

//todo: abstract parser with regex and matches
    //todo: reverse split order
public class LexicalUnitParser {
    private static final String LEXICAL_UNIT_SPLIT_REGEX = "\\p{Blank}+";
    private static final String PUNCTUATION_REGEX = "[\\p{Punct}\\u2026]";
    private static final String LETTER_REGEX = "\\p{L}";
    private static final String NUMERIC_REGEX = "\\p{Nd}";
    private static final String WORD_REGEX = LETTER_REGEX + "+";
    private static final String WORD_WITH_PUNCT_ENDS = WORD_REGEX + PUNCTUATION_REGEX;
    private static final String WORD_WITH_PUNCT_BEGINS_ENDS = PUNCTUATION_REGEX + WORD_WITH_PUNCT_ENDS;
    private static final String EXPRESSION_REGEX = "(" + PUNCTUATION_REGEX + "*" + NUMERIC_REGEX + "+" + PUNCTUATION_REGEX + "*)+";

    private static final Logger logger = LogManager.getLogger();

    private ExpressionParser expressionParser;
    private WordParser wordParser;
    private SymbolParser symbolParser;

    public LexicalUnitParser(){
        expressionParser = new ExpressionParser();
        wordParser = new WordParser();
        symbolParser = new SymbolParser();
    }

    public List<TextComponent> parseUnits(String sentence){
        List<String> lexicalUnits = Arrays.stream(sentence.split(LEXICAL_UNIT_SPLIT_REGEX))
                                          .collect(Collectors.toList());

        var unitComponents = new ArrayList<TextComponent>();

        for (String lexem: lexicalUnits) {
            if (lexem.length() == 1){
                Optional<? extends TextComponent> symbol;
                symbol = lexem.matches(LETTER_REGEX) ? Optional.of(wordParser.parseWord(lexem)) :
                         lexem.matches(PUNCTUATION_REGEX) ? Optional.of(symbolParser.parseSymbol(lexem.charAt(0))) :
                         lexem.matches(NUMERIC_REGEX) ? Optional.of(symbolParser.parseSymbol(lexem.charAt(0))):
                         Optional.empty();

                symbol.ifPresentOrElse(unitComponents::add, () -> logger.warn("Symbol '" + lexem + "' is unknown, can't parse it."));
            }
            else {
                if (lexem.matches(WORD_REGEX)){
                    var word = wordParser.parseWord(lexem);
                    unitComponents.add(word);
                }
                else if (lexem.matches(WORD_WITH_PUNCT_ENDS)){
                    var word = wordParser.parseWord(lexem.substring(0, lexem.length() - 1));
                    var character = symbolParser.parseSymbol(lexem.charAt(lexem.length() - 1), CharacterType.PUNCTUATION);

                    unitComponents.add(word);
                    unitComponents.add(character);
                }
                else if (lexem.matches(WORD_WITH_PUNCT_BEGINS_ENDS)){
                    var character1 = symbolParser.parseSymbol(lexem.charAt(0), CharacterType.PUNCTUATION);
                    var word = wordParser.parseWord(lexem.substring(1, lexem.length() - 1));
                    var character2 = symbolParser.parseSymbol(lexem.charAt(lexem.length() - 1), CharacterType.PUNCTUATION);

                    unitComponents.add(character1);
                    unitComponents.add(word);
                    unitComponents.add(character2);
                }
                else if (lexem.matches(EXPRESSION_REGEX)){
                    var expression = expressionParser.parseExpression(lexem);
                    unitComponents.add(expression);
                }
                else {
                    logger.warn("Lexical unit '" + lexem + "' is unknown, can't parse it.");
                }
            }
        }

        return unitComponents;
    }
}
