package edu.epam.second.interpreter.impl;

import edu.epam.second.interpreter.Context;
import edu.epam.second.interpreter.AbstractExpression;

public class TerminalExpressionUnsignedRightShift implements AbstractExpression {
    @Override
    public void interpret(Context context) {
        int shift = context.popValue();
        int value = context.popValue();
        context.pushValue(value >>> shift);
    }
}
