package Lab4.prodE;

public class CheckingAccount extends Account {
    private double balance;
    private double monthlyFee;
    private String acctId;

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
        return balance - monthlyFee;
    }

    public CheckingAccount(String acctId, double fee, double startBalance) {
        this.monthlyFee = fee;
        this.acctId = acctId;
        this.balance = startBalance;
    }

}
