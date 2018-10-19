package edu.epam.second.parser;

import edu.epam.second.action.NotationAction;
import edu.epam.second.entity.impl.WordComposite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpressionParser {
    private WordParser wordParser;
    private static final String UNSIGNED_SHIFT_REGEX = "(>){3}";
    private static final String UNSIGNED_SHIFT_SPLIT_REGEX = "(?<=(" + UNSIGNED_SHIFT_REGEX + "))|(?=(" + UNSIGNED_SHIFT_REGEX + "))";
    private static final String EXPRESSION_SPLIT_REGEX = "(?<=((>){2}|(<){2}|(&)|(\\^)|(~)|(\\|)|\\(|\\)))|(?=((>){2}|(<){2}|(&)|(\\^)|(~)|(\\|)|\\(|\\)))";

    public ExpressionParser(){
        wordParser = new WordParser();
    }

    public WordComposite parseExpression(String expression){
        List<String> splitExpression = splitExpression(expression);
        NotationAction notationAction = NotationAction.getInstance();
        System.out.println(notationAction.toPolishNotation(splitExpression));

        return null;
    }

    private List<String> splitExpression(String expression){
        List<String> splitExpression = new ArrayList<>();
        String[] splitByUnsignedShift = expression.split(UNSIGNED_SHIFT_SPLIT_REGEX);
        for (String expressionPart: splitByUnsignedShift) {
            if (!expressionPart.matches(UNSIGNED_SHIFT_REGEX)){
                List<String> array = Arrays.asList(expressionPart.split(EXPRESSION_SPLIT_REGEX));
                splitExpression.addAll(array);
            }
            else {
                splitExpression.add(expressionPart);
            }
        }

        return splitExpression;
    }
}
