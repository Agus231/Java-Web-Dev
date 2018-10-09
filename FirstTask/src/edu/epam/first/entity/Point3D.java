package edu.epam.first.entity;

public class Point3D {
    private double x;
    private double y;
    private double z;

    public Point3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }

        Point3D point  = (Point3D) obj;
        return (x == point.x && y == point.y && z == point.z);
    }

    @Override
    public int hashCode() {
        return (int) ((x * 31 + y * 67 + z * 153) % 137);
    }

    @Override
    public String toString() {
        return "Point [x=" + x + "; y=" + y + "; z=" + z + "]";
    }
}
