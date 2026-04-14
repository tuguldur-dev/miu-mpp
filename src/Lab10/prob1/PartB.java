package Lab10.prob1;

import java.util.function.Supplier;

public class PartB {
    static void main() {
        Supplier<Double> a = () -> Math.random();
        System.out.println(a.get());

        Dummy dummy = new Dummy();
        System.out.println(dummy.get());
    }

    static class Dummy implements Supplier {
        @Override
        public Object get() {
            return Math.random();
        }
    }
}

