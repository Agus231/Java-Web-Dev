package edu.epam.second.interpreter.expression.impl;

import edu.epam.second.interpreter.Context;
import edu.epam.second.interpreter.expression.AbstractExpression;

public class NonTerminalExpression implements AbstractExpression {
    private int number;

    public NonTerminalExpression(int number){
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}
