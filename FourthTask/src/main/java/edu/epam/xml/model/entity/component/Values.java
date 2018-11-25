package edu.epam.xml.model.entity.component;

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
    public String toString() {
        return "Values{" +
                "proteins=" + proteins +
                ", fats=" + fats +
                ", starches=" + starches +
                '}';
    }
}
