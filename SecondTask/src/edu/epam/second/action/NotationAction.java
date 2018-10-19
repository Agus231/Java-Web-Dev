package edu.epam.second.action;

import edu.epam.second.operation.NotationOperator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class NotationAction {
    private static final NotationAction instance = new NotationAction();

    private NotationAction(){
    }

    public static NotationAction getInstance(){
        return instance;
    }

    private boolean checkPriority(NotationOperator stackPeek, NotationOperator currentOperation) {
        return (stackPeek != NotationOperator.OPEN_BRACKET && stackPeek.getPriority() > currentOperation.getPriority());
    }

    //todo: regex
    public List<String> toPolishNotation(List<String> expressionParts){
        ArrayDeque<NotationOperator> stack = new ArrayDeque<>();
        List<String> polishExpression = new ArrayList<>();

        for (String part: expressionParts) {
            if (part.matches("\\d+")){
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
                        while (!stack.isEmpty() && checkPriority(stack.peek(), NotationOperator.UNSIGNED_RIGH_SHIFT)){
                            polishExpression.add(stack.pop().getValue());
                        }
                        stack.push(NotationOperator.UNSIGNED_RIGH_SHIFT);
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

}
