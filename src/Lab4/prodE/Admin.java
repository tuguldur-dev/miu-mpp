package Lab4.prodE;

import java.util.List;

public class Admin {
    public static double computeUpdatedBalanceSum(List<Employee> list) {
        double total = 0;
        for (Employee e : list) {
            total += e.computeUpdatedBalance();
        }
        return total;
    }
}
