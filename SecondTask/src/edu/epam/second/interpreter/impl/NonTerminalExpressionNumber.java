package edu.epam.second.interpreter.impl;

import edu.epam.second.interpreter.Context;
import edu.epam.second.interpreter.AbstractExpression;

public class NonTerminalExpressionNumber implements AbstractExpression {
    private int number;

    public NonTerminalExpressionNumber(int number){
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}
