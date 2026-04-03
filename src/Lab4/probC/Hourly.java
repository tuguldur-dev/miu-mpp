package Lab4.probC;

public class Hourly extends Employee {
    private double hourlyWage;
    private double hoursPerWeek;

    @Override
    public double calcGrossPay(int month, int year) {
        return hourlyWage * hoursPerWeek * 4;
    }

    public Hourly(String empId, double hourlyWage, double hoursPerWeek) {
        this.hourlyWage = hourlyWage;
        this.hoursPerWeek = hoursPerWeek;
        super(empId);
    }
}
