package Lab4.probC;

public class Salaried extends Employee{
    private double salary;
    @Override
    public double calcGrossPay(int month, int year) {
        return salary;
    }

    public Salaried(String empId, double salary) {
        this.salary = salary;
        super(empId);
    }
}
