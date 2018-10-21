package edu.epam.second.interpreter.expression;

import edu.epam.second.interpreter.Context;

public interface AbstractExpression {
    void interpret(Context context);
}
