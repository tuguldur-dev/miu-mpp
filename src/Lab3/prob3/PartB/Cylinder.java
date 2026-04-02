package Lab3.prob3.PartB;

public class Cylinder {
    private Circle base;
    private double height;

    public Cylinder(double radius, double height) {
        this.base = new Circle(radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double computeVolume() {
        return base.computeArea() * height;
    }
}