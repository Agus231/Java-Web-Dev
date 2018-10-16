package edu.epam.second.action;

import edu.epam.second.operation.NotationOperator;

import java.util.ArrayDeque;

public class NotationAction {
    private static final NotationAction instance = new NotationAction();

    private NotationAction(){
    }

    public static NotationAction getInstance(){
        return instance;
    }

    //todo: make right tripple shift
    public String toPolishNotation(String expression){
        char[] charArray = expression.toCharArray();

        ArrayDeque<NotationOperator> stack = new ArrayDeque<>();
        StringBuilder resultString = new StringBuilder();

        int i = 0;

        while (i != charArray.length){
            if (Character.isDigit(charArray[i])){
                String decimal = createDecimal(charArray, i);
                i += decimal.length();
                resultString.append(decimal).append(" ");
            }
            if (i == charArray.length) break;

            switch (charArray[i]) {
                case '~':
                    stack.push(NotationOperator.INVERSE);
                    i++;
                    break;
                case '(':
                    stack.push(NotationOperator.OPEN_BRACKET);
                    i++;
                    break;
                case ')':
                    while (stack.peek() != NotationOperator.OPEN_BRACKET){
                        resultString.append(stack.pop().getValue()).append(" ");
                    }
                    stack.pop();
                    i++;
                    break;
                case '<':
                    while (!stack.isEmpty() && (stack.peek() == NotationOperator.INVERSE || (stack.peek() != NotationOperator.OPEN_BRACKET && stack.peek().getPriority() > NotationOperator.SIGNED_LEFT_SHIFT.getPriority()))){
                        resultString.append(stack.pop().getValue()).append(" ");
                    }
                    stack.push(NotationOperator.SIGNED_LEFT_SHIFT);
                    i+=2;
                    break;
                case '>':
                    while (!stack.isEmpty() && (stack.peek() == NotationOperator.INVERSE || (stack.peek() != NotationOperator.OPEN_BRACKET && stack.peek().getPriority() > NotationOperator.SIGNED_RIGHT_SHIFT.getPriority()))){
                        resultString.append(stack.pop().getValue()).append(" ");
                    }
                    stack.push(NotationOperator.SIGNED_RIGHT_SHIFT);
                    i+=2;
                    break;
                case '&':
                    while (!stack.isEmpty() && (stack.peek() == NotationOperator.INVERSE || (stack.peek() != NotationOperator.OPEN_BRACKET && stack.peek().getPriority() > NotationOperator.AND.getPriority()))){
                        resultString.append(stack.pop().getValue()).append(" ");
                    }
                    stack.push(NotationOperator.AND);
                    i++;
                    break;
                case '^':
                    while (!stack.isEmpty() && (stack.peek() == NotationOperator.INVERSE || (stack.peek() != NotationOperator.OPEN_BRACKET && stack.peek().getPriority() > NotationOperator.XOR.getPriority()))){
                        resultString.append(stack.pop().getValue()).append(" ");
                    }
                    stack.push(NotationOperator.XOR);
                    i++;
                    break;
                case '|':
                    while (!stack.isEmpty() && (stack.peek() == NotationOperator.INVERSE || (stack.peek() != NotationOperator.OPEN_BRACKET && stack.peek().getPriority() > NotationOperator.OR.getPriority()))){
                        resultString.append(stack.pop().getValue()).append(" ");
                    }
                    stack.push(NotationOperator.OR);
                    i++;
                    break;
                    default:
                        break;
            }
        }

        while (!stack.isEmpty()){
            resultString.append(stack.pop().getValue()).append(" ");
        }

        return resultString.toString().trim();
    }

    private String createDecimal(char[] characters, int index){
        StringBuilder notationPart = new StringBuilder();

        while (index != characters.length && Character.isDigit(characters[index])){
            notationPart.append(characters[index]);
            index++;
        }

        return notationPart.toString();
    }
}
