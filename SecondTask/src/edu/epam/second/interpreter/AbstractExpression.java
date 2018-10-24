package edu.epam.second.interpreter;

import edu.epam.second.interpreter.Context;

public interface AbstractExpression {
    void interpret(Context context);
}
