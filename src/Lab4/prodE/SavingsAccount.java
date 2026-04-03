package Lab4.prodE;

public class SavingsAccount extends Account {
    private double balance;
    private double interestRate;
    private String acctId;

    public SavingsAccount(String acctId, double interestRate, double startBalance) {
        this.balance = startBalance;
        this.acctId = acctId;
        this.interestRate = interestRate;
    }

    @Override
    public String getAccountID() {
        return this.acctId;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public double computeUpdatedBalance() {
        return balance + (interestRate * balance);
    }
}
