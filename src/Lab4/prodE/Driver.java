package Lab4.prodE;

import java.util.List;

public class Driver {
    public static void main(String[] args) {
        Employee e1 = new Employee("Alice");
        e1.addAccount(new CheckingAccount("C1", 5.0, 1000.0));
        e1.addAccount(new SavingsAccount("S1", 0.05, 2000.0));

        Employee e2 = new Employee("Bob");
        e2.addAccount(new CheckingAccount("C2", 10.0, 500.0));

        System.out.println("Total: " + Admin.computeUpdatedBalanceSum(List.of(e1, e2)));
    }
}
