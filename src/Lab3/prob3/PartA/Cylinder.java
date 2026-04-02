package Lab3.prob3.PartA;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getHeight() { return height; }

    public double computeVolume() {
        return computeArea() * height;
    }
}