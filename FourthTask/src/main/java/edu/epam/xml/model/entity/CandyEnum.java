package edu.epam.xml.model.entity;

public enum  CandyEnum {
    CANDIES,
    SIMPLE_CANDY,
    CHOCOLATE_CANDY,
    VALUES,
    INGREDIENTS,
    NAME,
    ENERGY,
    PRODUCTION,
    CHOCOLATE_TYPE,
    PRODUCED_DATE,
    PROTEINS,
    FATS,
    STARCHES,
    WATER,
    SUGAR,
    FRUCTOSE,
    VANILLA,
    ID,
    TYPE;

    private static final String UNDERSCORE = "_";
    private static final String DASH = "-";

    public String getTag(){
        return name().replaceAll(UNDERSCORE, DASH).toLowerCase();
    }

    public static String toEnumFormat(String name){
        return name.replaceAll(DASH, UNDERSCORE).toUpperCase();
    }

}
