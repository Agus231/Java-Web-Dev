package edu.epam.xml.model.entity;

public class Values {
    private int proteins;
    private int fats;
    private int starches;

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getStarches() {
        return starches;
    }

    public void setStarches(int starches) {
        this.starches = starches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Values values = (Values) o;

        if (proteins != values.proteins) return false;
        if (fats != values.fats) return false;
        return starches == values.starches;
    }

    @Override
    public int hashCode() {
        int result = proteins;
        result = 31 * result + fats;
        result = 31 * result + starches;
        return result;
    }

    @Override
    public String toString() {
        return "Values{" +
                "proteins=" + proteins +
                ", fats=" + fats +
                ", starches=" + starches +
                '}';
    }
}
