package edu.epam.second.parser.impl;

import edu.epam.second.entity.TextComponent;
import edu.epam.second.entity.impl.TextComposite;
import edu.epam.second.entity.type.CharacterType;
import edu.epam.second.entity.type.ComponentType;
import edu.epam.second.parser.BaseParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class LexicalUnitParser implements BaseParser {
    private static final Logger logger = LogManager.getLogger();

    private ExpressionParser expressionParser;
    private WordParser wordParser;
    private SymbolParser symbolParser;

    public LexicalUnitParser(){
        expressionParser = new ExpressionParser();
        wordParser = new WordParser();
        symbolParser = new SymbolParser();
    }

    @Override
    public TextComponent parseTextPart(String unit){
        var lexicalUnit = new TextComposite(ComponentType.LEXICALUNIT);

        if (unit.length() == 1){
            Optional<? extends TextComponent> symbol;
            symbol = unit.matches(LETTER_REGEX) ? Optional.of(wordParser.parseTextPart(unit)) :
                     unit.matches(PUNCTUATION_REGEX) ? Optional.of(symbolParser.parseTextPart(String.valueOf(unit.charAt(0)))) :
                     unit.matches(NUMERIC_REGEX) ? Optional.of(symbolParser.parseTextPart(String.valueOf(unit.charAt(0)))):
                     Optional.empty();

            symbol.ifPresentOrElse(lexicalUnit::add, () -> logger.warn("Symbol '" + unit + "' is unknown, can't parse it."));
        }
        else {
            if (unit.matches(WORD_REGEX) || unit.matches(COMPLICATED_WORD)){
                var word = wordParser.parseTextPart(unit);
                lexicalUnit.add(word);
            }
            else if (unit.matches(WORD_WITH_PUNCT_ENDS)){
                var word = wordParser.parseTextPart(unit.substring(0, unit.length() - 1));
                var character = symbolParser.parseTextPart(String.valueOf(unit.charAt(unit.length() - 1)), CharacterType.PUNCTUATION);

                lexicalUnit.add(word);
                lexicalUnit.add(character);
            }
            else if (unit.matches(WORD_WITH_PUNCT_BEGINS)){
                var character = symbolParser.parseTextPart(String.valueOf(unit.charAt(0)), CharacterType.PUNCTUATION);
                var word = wordParser.parseTextPart(unit.substring(1, unit.length()));

                lexicalUnit.add(character);
                lexicalUnit.add(word);
            }
            else if (unit.matches(WORD_WITH_TWO_PUNCT_ENDS)){
                var word = wordParser.parseTextPart(unit.substring(0, unit.length() - 2));
                var character1 = symbolParser.parseTextPart(String.valueOf(unit.charAt(unit.length() - 2)), CharacterType.PUNCTUATION);
                var character2 = symbolParser.parseTextPart(String.valueOf(unit.charAt(unit.length() - 1)), CharacterType.PUNCTUATION);

                lexicalUnit.add(word);
                lexicalUnit.add(character1);
                lexicalUnit.add(character2);
            }
            else if (unit.matches(WORD_WITH_PUNCT_BEGINS_ENDS)){
                var character1 = symbolParser.parseTextPart(String.valueOf(unit.charAt(0)), CharacterType.PUNCTUATION);
                var word = wordParser.parseTextPart(unit.substring(1, unit.length() - 1));
                var character2 = symbolParser.parseTextPart(String.valueOf(unit.charAt(unit.length() - 1)), CharacterType.PUNCTUATION);

                lexicalUnit.add(character1);
                lexicalUnit.add(word);
                lexicalUnit.add(character2);
            }
            else if (unit.matches(WORD_WITH_TWO_PUNCT_BEGINS_ENDS)){
                var character1 = symbolParser.parseTextPart(String.valueOf(unit.charAt(0)), CharacterType.PUNCTUATION);
                var word = wordParser.parseTextPart(unit.substring(1, unit.length() - 2));
                var character2 = symbolParser.parseTextPart(String.valueOf(unit.charAt(unit.length() - 2)), CharacterType.PUNCTUATION);
                var character3 = symbolParser.parseTextPart(String.valueOf(unit.charAt(unit.length() - 1)), CharacterType.PUNCTUATION);

                lexicalUnit.add(character1);
                lexicalUnit.add(word);
                lexicalUnit.add(character2);
                lexicalUnit.add(character3);
            }
            else if (unit.matches(EXPRESSION_REGEX)){
                var expression = expressionParser.parseTextPart(unit);
                lexicalUnit.add(expression);
            }
            else {
                logger.warn("Lexical unit '" + unit + "' is unknown, can't parse it.");
            }
        }

        return lexicalUnit;
    }
}
