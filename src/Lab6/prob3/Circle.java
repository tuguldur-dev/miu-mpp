package Lab6.prob3;

public class Circle implements Shapeable {
    public Circle(double radius) {
        this.radius = radius;
    }

    private double radius;

    @Override
    public double computeArea() {
        return Math.PI * radius * radius;
    }
}
