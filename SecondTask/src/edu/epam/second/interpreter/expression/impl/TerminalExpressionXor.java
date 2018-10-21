package edu.epam.second.interpreter.expression.impl;

import edu.epam.second.interpreter.Context;
import edu.epam.second.interpreter.expression.AbstractExpression;

public class TerminalExpressionXor implements AbstractExpression {
    @Override
    public void interpret(Context context) {
        context.pushValue(context.popValue() ^ context.popValue());
    }
}
