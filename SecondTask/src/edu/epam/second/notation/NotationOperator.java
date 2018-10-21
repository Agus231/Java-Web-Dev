package edu.epam.second.notation;

public enum NotationOperator {
    OPEN_BRACKET("(", 6),
    CLOSE_BRAKCET(")", 6),
    INVERSE("~", 5),
    SIGNED_LEFT_SHIFT("<<", 4),
    SIGNED_RIGHT_SHIFT(">>", 4),
    UNSIGNED_RIGHT_SHIFT(">>>", 4),
    AND("&", 3),
    XOR("^", 2),
    OR("|", 1);

    private String value;
    private int priority;

    NotationOperator(String value, int priority){
        this.value = value;
        this.priority = priority;
    }

    public String getValue() {
        return value;
    }

    public int getPriority() {
        return priority;
    }
}
