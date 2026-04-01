package Lab2.prob2B;

public class Main {
    static void main() {
        Order o = new Order(1001);
        o.addOrderLine();
        o.addOrderLine();

        System.out.println(o);
    }
}
