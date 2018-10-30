package edu.epam.second.notation;

import edu.epam.second.interpreter.Context;
import edu.epam.second.interpreter.AbstractExpression;
import edu.epam.second.interpreter.impl.*;
import edu.epam.second.parser.BaseParser;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class NotationAction {
    private static final NotationAction INSTANCE = new NotationAction();

    private static final String INVERSE = "~";
    private static final String OPEN_BRACKET = "(";
    private static final String CLOSE_BRACKET = ")";
    private static final String SIGNED_LEFT_SHIFT = "<<";
    private static final String SIGNED_RIGHT_SHIFT = ">>";
    private static final String UNSIGNED_RIGHT_SHIFT = ">>>";
    private static final String AMPERSAND = "&";
    private static final String CIRCUMFLEX = "^";
    private static final String VERTICAL_LINE = "|";

    private NotationAction(){}

    public static NotationAction getInstance(){
        return INSTANCE;
    }

    private boolean checkPriority(NotationOperator stackPeek, NotationOperator currentOperation) {
        return (stackPeek != NotationOperator.OPEN_BRACKET && stackPeek.getPriority() > currentOperation.getPriority());
    }

    private List<String> toPolishNotation(List<String> expressionParts){
        var stack = new ArrayDeque<NotationOperator>();
        var polishExpression = new ArrayList<String>();

        for (String part: expressionParts) {
            if (part.matches(BaseParser.NUMBER_REGEX)){
                polishExpression.add(part);
            }
            else {
                switch (part){
                    case INVERSE:
                        stack.push(NotationOperator.INVERSE);
                        break;
                    case OPEN_BRACKET:
                        stack.push(NotationOperator.OPEN_BRACKET);
                        break;
                    case CLOSE_BRACKET:
                        while (stack.peek() != NotationOperator.OPEN_BRACKET){
                            polishExpression.add(stack.pop().getValue());
                        }
                        stack.pop();
                        break;
                    case SIGNED_LEFT_SHIFT:
                        while (!stack.isEmpty() && checkPriority(stack.peek(), NotationOperator.SIGNED_LEFT_SHIFT)){
                            polishExpression.add(stack.pop().getValue());
                        }
                        stack.push(NotationOperator.SIGNED_LEFT_SHIFT);
                        break;
                    case SIGNED_RIGHT_SHIFT:
                        while (!stack.isEmpty() && checkPriority(stack.peek(), NotationOperator.SIGNED_RIGHT_SHIFT)){
                            polishExpression.add(stack.pop().getValue());
                        }
                        stack.push(NotationOperator.SIGNED_RIGHT_SHIFT);
                        break;
                    case UNSIGNED_RIGHT_SHIFT:
                        while (!stack.isEmpty() && checkPriority(stack.peek(), NotationOperator.UNSIGNED_RIGHT_SHIFT)){
                            polishExpression.add(stack.pop().getValue());
                        }
                        stack.push(NotationOperator.UNSIGNED_RIGHT_SHIFT);
                        break;
                    case AMPERSAND:
                        while (!stack.isEmpty() && checkPriority(stack.peek(), NotationOperator.AND)){
                            polishExpression.add(stack.pop().getValue());
                        }
                        stack.push(NotationOperator.AND);
                        break;
                    case CIRCUMFLEX:
                        while (!stack.isEmpty() && checkPriority(stack.peek(), NotationOperator.XOR)){
                            polishExpression.add(stack.pop().getValue());
                        }
                        stack.push(NotationOperator.XOR);
                        break;
                    case VERTICAL_LINE:
                        while (!stack.isEmpty() && checkPriority(stack.peek(), NotationOperator.OR)){
                            polishExpression.add(stack.pop().getValue());
                        }
                        stack.push(NotationOperator.OR);
                        break;
                        default:
                            break;
                }
            }
        }

        while (!stack.isEmpty()){
            polishExpression.add(stack.pop().getValue());
        }

        return polishExpression;
    }

    private List<AbstractExpression> prepareExpressionParts(List<String> parts){
        var listExpression = new ArrayList<AbstractExpression>();
        for (String part: parts) {
            switch (part){
                case INVERSE:
                    listExpression.add(new TerminalExpressionInverse());
                    break;
                case VERTICAL_LINE:
                    listExpression.add(new TerminalExpressionOr());
                    break;
                case AMPERSAND:
                    listExpression.add(new TerminalExpressionAnd());
                    break;
                case CIRCUMFLEX:
                    listExpression.add(new TerminalExpressionXor());
                    break;
                case SIGNED_LEFT_SHIFT:
                    listExpression.add(new TerminalExpressionSignedLeftShift());
                    break;
                case SIGNED_RIGHT_SHIFT:
                    listExpression.add(new TerminalExpressionSignedRightShift());
                    break;
                case UNSIGNED_RIGHT_SHIFT:
                    listExpression.add(new TerminalExpressionUnsignedRightShift());
                    break;
                default:
                    int value = Integer.parseInt(part);
                    listExpression.add(new NonTerminalExpressionNumber(value));
                    break;
            }
        }
        return listExpression;
    }

    public Integer calculateExpression(List<String> expression){
        List<String> polishExpression = toPolishNotation(expression);

        List<AbstractExpression> expressions = prepareExpressionParts(polishExpression);
        var context = new Context();

        for (AbstractExpression expressionPart: expressions) {
            expressionPart.interpret(context);
        }

        return context.popValue();
    }


}
