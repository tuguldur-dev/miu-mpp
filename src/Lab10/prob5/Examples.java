package Lab10.prob5;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Examples {
    Function<Employee, String> getName = Employee::getName;
    BiConsumer<Employee, String> setName = Employee::setName;
    BiFunction<String, String, Integer> compareTo = String::compareTo;
    BiFunction<Integer, Integer, Double> pow = Math::pow;
    Function<Apple, Integer> getWeight = Apple::getWeight;
    Function<String, Integer> parseInt = Integer::parseInt;
    EmployeeNameComparator comp = new EmployeeNameComparator();
    BiFunction<Employee, Employee, Integer> compareToEmployee = comp::compare;


    void evaluator() {
        Employee e = new Employee("Rahul", 5000);

        System.out.println(getName.apply(e));
        setName.accept(e, "Luel");
        System.out.println(getName.apply(e));
        System.out.println(compareTo.apply("a", "b"));
        System.out.println(pow.apply(2, 3));
        System.out.println(getWeight.apply(new Apple(10)));
        System.out.println(parseInt.apply("123"));
    }

    static void main() {
        new Examples().evaluator();
    }
}
