package Lab3.prob3.PartA;

public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() { return radius; }

    public double computeArea() {
        return Math.PI * radius * radius;
    }
}