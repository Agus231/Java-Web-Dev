package edu.epam.second.parser.impl;

import edu.epam.second.notation.NotationAction;
import edu.epam.second.entity.impl.NumberComposite;
import edu.epam.second.parser.BaseParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpressionParser implements BaseParser {
    private NumberParser numberParser;

    public ExpressionParser(){
        numberParser = new NumberParser();
    }

    @Override
    public NumberComposite parseTextPart(String expression){
        List<String> splitExpression = splitExpression(expression);
        NotationAction notationAction = NotationAction.getInstance();

        Integer expressionResult = notationAction.calculateExpression(splitExpression);

        return numberParser.parseTextPart(String.valueOf(expressionResult));
    }

    private List<String> splitExpression(String expression){
        var splitExpression = new ArrayList<String>();
        String[] splitByUnsignedShift = expression.split(UNSIGNED_SHIFT_SPLIT_REGEX);
        for (String expressionPart: splitByUnsignedShift) {
            if (expressionPart.matches(UNSIGNED_SHIFT_REGEX)){
                splitExpression.add(expressionPart);
            }
            else {
                List<String> array = Arrays.asList(expressionPart.split(EXPRESSION_SPLIT_REGEX));
                splitExpression.addAll(array);
            }
        }

        return splitExpression;
    }
}
