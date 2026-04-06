package Lab6.prob3;

public class Main {

    static void main() {
        Shapeable[] shapeables = {
                new Circle(10),
                new Rectangle(10, 20),
                new Triangle(10, 15)
        };

        for (Shapeable shapeable : shapeables) {
            System.out.printf("%s: %.2f\n", shapeable.getClass().getSimpleName(), shapeable.computeArea());
        }
    }
}
