package Lab9.prob2;

public class Main {
    sealed interface Expr {
    }

    record Constants(int value) implements Expr {
    }

    record Addition(Expr value1, Expr value2) implements Expr {
    }

    record Multiplication(Expr value1, Expr value2) implements Expr {

    }
    public static void main() {
        Expr expr = new Multiplication(
                new Addition(new Constants(2), new Constants(3)),
                new Constants(4)
        );

        System.out.println(eval(expr));
    }

    static int eval(Expr expr) {
        if (expr instanceof Constants(int value)) {
            return value;
        } else if (expr instanceof Addition(Expr value1, Expr value2)) {
            return eval(value1) + eval(value2);
        } else if (expr instanceof Multiplication(Expr value1, Expr value2)) {
            return eval(value1) * eval(value2);
        }
        return -1;
    }
}

