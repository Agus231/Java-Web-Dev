package edu.epam.xml.model.entity;

public class SimpleCandy extends Candy {
    public enum SimpleCandyType {
        CARAMEL("Caramel"), IRIS("Iris");

        private String value;

        SimpleCandyType(String value){
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    @Override
    public String toString() {
        return "SimpleCandy{" +
                "type='" + type + '\'' +
                ", candyId='" + candyId + '\'' +
                ", name='" + name + '\'' +
                ", energy=" + energy +
                ", production='" + production + '\'' +
                ", producedDate=" + producedDate +
                ", values=" + values +
                ", ingredients=" + ingredients +
                '}';
    }
}
