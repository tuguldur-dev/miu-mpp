package Lab6.prob3;

public class Triangle implements Shapeable {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double computeArea() {
        return (base * height) / 2;
    }
}
