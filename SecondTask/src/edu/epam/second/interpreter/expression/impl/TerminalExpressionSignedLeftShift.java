package edu.epam.second.interpreter.expression.impl;

import edu.epam.second.interpreter.Context;
import edu.epam.second.interpreter.expression.AbstractExpression;

public class TerminalExpressionSignedLeftShift implements AbstractExpression {
    @Override
    public void interpret(Context context) {
        int shift = context.popValue();
        int value = context.popValue();
        context.pushValue(value << shift);
    }
}
