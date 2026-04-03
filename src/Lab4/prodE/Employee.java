package Lab4.prodE;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private List<Account> accounts;

    public Employee(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAccount(Account acct) {
        this.accounts.add(acct);
    }

    public double computeUpdatedBalance() {
        double total = 0;
        for (Account account : accounts) {
            total += account.computeUpdatedBalance();
        }
        return total;
    }

}
