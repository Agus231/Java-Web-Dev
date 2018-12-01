package edu.epam.xml.model.entity;

public class Ingredients {
    protected int water;
    protected int sugar;
    protected int fructose;
    protected int vanilla;

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getFructose() {
        return fructose;
    }

    public void setFructose(int fructose) {
        this.fructose = fructose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredients that = (Ingredients) o;

        if (water != that.water) return false;
        if (sugar != that.sugar) return false;
        if (fructose != that.fructose) return false;
        return vanilla == that.vanilla;
    }

    @Override
    public int hashCode() {
        int result = water;
        result = 31 * result + sugar;
        result = 31 * result + fructose;
        result = 31 * result + vanilla;
        return result;
    }

    public int getVanilla() {
        return vanilla;
    }

    public void setVanilla(int vanilla) {
        this.vanilla = vanilla;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "water=" + water +
                ", sugar=" + sugar +
                ", fructose=" + fructose +
                ", vanilla=" + vanilla +
                '}';
    }
}
