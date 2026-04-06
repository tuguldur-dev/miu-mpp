package Lab6.prob3;

public class Rectangle implements Shapeable {
    private double width;
    private double height;
    @Override
    public double computeArea() {
        return width * height;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
}
