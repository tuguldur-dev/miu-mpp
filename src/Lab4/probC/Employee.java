package Lab4.probC;

public abstract class Employee {
    private String empId;

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                '}';
    }

    public Employee(String empId) {
        this.empId = empId;
    }

    public void print() {
        System.out.println(this);
    }

    public Paycheck calcCompensation(int month, int year) {
        double fica = 0.23;
        double stateTax = 0.05;
        double localTax = 0.01;
        double medicare = 0.03;
        double socialSecurity = 0.075;
        double gross = this.calcGrossPay(month, year);
        return new Paycheck(gross, gross * fica, gross * stateTax, gross * localTax, gross * medicare, gross * socialSecurity);

    }

    public abstract double calcGrossPay(int month, int year);
}
