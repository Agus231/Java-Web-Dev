package edu.epam.second.interpreter.impl;

import edu.epam.second.interpreter.Context;
import edu.epam.second.interpreter.AbstractExpression;

public class TerminalExpressionAnd implements AbstractExpression {
    @Override
    public void interpret(Context context) {
        context.pushValue(context.popValue() & context.popValue());
    }
}
