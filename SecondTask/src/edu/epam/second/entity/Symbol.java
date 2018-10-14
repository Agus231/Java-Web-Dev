package edu.epam.second.entity;

import edu.epam.second.Component;
import java.util.List;
import java.util.Objects;

public class Symbol implements Component<Component> {
    private String value;

    public Symbol(Character symbol){
        value = symbol.toString();
    }

    @Override
    public void operation() {
        System.out.print(value);
    }

    @Override
    public boolean add(Component component) {
        return false;
    }

    @Override
    public boolean addAll(List<Component> component) {
        return false;
    }

    @Override
    public boolean remove(Component component) {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol = (Symbol) o;
        return Objects.equals(value, symbol.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "value='" + value + '\'' +
                '}';
    }
}
