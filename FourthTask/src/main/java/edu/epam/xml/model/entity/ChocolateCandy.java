package edu.epam.xml.model.entity;

public class ChocolateCandy extends Candy {
    private String chocolateType;
    private static final ChocolateCandyType DEFAULT_TYPE = ChocolateCandyType.CHOCOLATE;

    public ChocolateCandy(){
        type = DEFAULT_TYPE;
    }

    public enum ChocolateCandyType{
        CHOCOLATE("Chocolate"), CHOCOLATE_WITH_FILLING("Chocolate with filling");

        private String value;

        ChocolateCandyType(String value){
            this.value = value;
        }

        public static String toEnumFormat(String name){
            return name.replaceAll(" ", "_").toUpperCase();
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public String getChocolateType() {
        return chocolateType;
    }

    public void setChocolateType(String chocolateType) {
        this.chocolateType = chocolateType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ChocolateCandy that = (ChocolateCandy) o;

        return chocolateType != null ? chocolateType.equals(that.chocolateType) : that.chocolateType == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (chocolateType != null ? chocolateType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ChocolateCandy{" +
                "type='" + type + '\'' +
                ", chocolateType='" + chocolateType + '\'' +

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
