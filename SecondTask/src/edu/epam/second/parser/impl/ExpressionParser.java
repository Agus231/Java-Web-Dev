package edu.epam.second.parser.impl;

import edu.epam.second.action.NotationAction;
import edu.epam.second.entity.impl.WordComposite;
import edu.epam.second.parser.BaseParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpressionParser implements BaseParser {
    private WordParser wordParser;

    public ExpressionParser(){
        wordParser = new WordParser();
    }

    @Override
    public WordComposite parseTextPart(String expression){
        List<String> splitExpression = splitExpression(expression);
        NotationAction notationAction = NotationAction.getInstance();


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
