package edu.epam.second.notation;

import edu.epam.second.interpreter.Context;
import edu.epam.second.interpreter.expression.AbstractExpression;
import edu.epam.second.interpreter.expression.impl.*;
import edu.epam.second.parser.BaseParser;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class NotationAction {
    private static final NotationAction instance = new NotationAction();

    private NotationAction(){}

    public static NotationAction getInstance(){
        return instance;
    }

    private boolean checkPriority(NotationOperator stackPeek, NotationOperator currentOperation) {
        return (stackPeek != NotationOperator.OPEN_BRACKET && stackPeek.getPriority() > currentOperation.getPriority());
    }

    private List<String> toPolishNotation(List<String> expressionParts){
        ArrayDeque<NotationOperator> stack = new ArrayDeque<>();
        List<String> polishExpression = new ArrayList<>();

        for (String part: expressionParts) {
            if (part.matches(BaseParser.NUMBER_REGEX)){
                polishExpression.add(part);
            }
            else {
                switch (part){
                    case "~":
                        stack.push(NotationOperator.INVERSE);
                        break;
                    case "(":
                        stack.push(NotationOperator.OPEN_BRACKET);
                        break;
                    case ")":
                        while (stack.peek() != NotationOperator.OPEN_BRACKET){
                            polishExpression.add(stack.pop().getValue());
                        }
                        stack.pop();
                        break;
                    case "<<":
                        while (!stack.isEmpty() && checkPriority(stack.peek(), NotationOperator.SIGNED_LEFT_SHIFT)){
                            polishExpression.add(stack.pop().getValue());
                        }
                        stack.push(NotationOperator.SIGNED_LEFT_SHIFT);
                        break;
                    case ">>":
                        while (!stack.isEmpty() && checkPriority(stack.peek(), NotationOperator.SIGNED_RIGHT_SHIFT)){
                            polishExpression.add(stack.pop().getValue());
                        }
                        stack.push(NotationOperator.SIGNED_RIGHT_SHIFT);
                        break;
                    case ">>>":
                        while (!stack.isEmpty() && checkPriority(stack.peek(), NotationOperator.UNSIGNED_RIGHT_SHIFT)){
                            polishExpression.add(stack.pop().getValue());
                        }
                        stack.push(NotationOperator.UNSIGNED_RIGHT_SHIFT);
                        break;
                    case "&":
                        while (!stack.isEmpty() && checkPriority(stack.peek(), NotationOperator.AND)){
                            polishExpression.add(stack.pop().getValue());
                        }
                        stack.push(NotationOperator.AND);
                        break;
                    case "^":
                        while (!stack.isEmpty() && checkPriority(stack.peek(), NotationOperator.XOR)){
                            polishExpression.add(stack.pop().getValue());
                        }
                        stack.push(NotationOperator.XOR);
                        break;
                    case "|":
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
        ArrayList<AbstractExpression> listExpression = new ArrayList<>();
        for (String part : parts) {
            switch (part){
                case "~":
                    listExpression.add(new TerminalExpressionInverse());
                    break;
                case "|":
                    listExpression.add(new TerminalExpressionOr());
                    break;
                case "&":
                    listExpression.add(new TerminalExpressionAnd());
                    break;
                case "^":
                    listExpression.add(new TerminalExpressionXor());
                    break;
                case "<<":
                    listExpression.add(new TerminalExpressionSignedLeftShift());
                    break;
                case ">>":
                    listExpression.add(new TerminalExpressionSignedRightShift());
                    break;
                case ">>>":
                    listExpression.add(new TerminalExpressionUnsignedRightShift());
                    break;
                default:
                    int value = Integer.parseInt(part);
                    listExpression.add(new NonTerminalExpression(value));
                    break;
            }
        }
        return listExpression;
    }

    public Integer calculateExpression(List<String> expression){
        List<String> polishExpression = toPolishNotation(expression);

        List<AbstractExpression> expressions = prepareExpressionParts(polishExpression);
        Context context = new Context();

        for (AbstractExpression expressionPart: expressions) {
            expressionPart.interpret(context);
        }

        return context.popValue();
    }


}