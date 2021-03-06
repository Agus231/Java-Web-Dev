package edu.epam.first.registrator;

public class Parameters {
    private double area;
    private double volume;

    public Parameters(double area, double volume){
        this.area = area;
        this.volume = volume;
    }

    public double getArea() {
        return area;
    }

    public double getVolume() {
        return volume;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Parameters that = (Parameters) o;
        return Double.compare(that.area, area) == 0 &&
                Double.compare(that.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        return (int)((area * 31 + volume * 57) % 23);
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "area=" + area +
                ", volume=" + volume +
                '}';
    }
}
