package edu.epam.xml.model.entity;

public class SimpleCandy extends Candy {
    private static final SimpleCandyType DEFAULT_TYPE = SimpleCandyType.CARAMEL;

    public SimpleCandy(){
        type = DEFAULT_TYPE;
    }

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
