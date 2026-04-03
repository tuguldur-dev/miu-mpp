package Lab4.probC;

import java.util.List;

public class Commissioned extends Employee{
    private double commission;
    private double baseSalary;
    private List<Order> orders;

    public Commissioned(String empId, double commission, double baseSalary, List<Order> orders) {
        this.commission = commission;
        this.baseSalary = baseSalary;
        this.orders = orders;
        super(empId);
    }

    @Override
    public double calcGrossPay(int month, int year) {
        double totalSales = 0;

        int targetMonth = (month == 1) ? 12 : month - 1;
        int targetYear = (month == 1) ? year - 1 : year;

        for (Order order : orders) {
            if (order.getOrderDate().getMonthValue() == targetMonth &&
                    order.getOrderDate().getYear() == targetYear) {
                totalSales += order.getOrderAmount();
            }
        }

        return baseSalary + (totalSales * commission);
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
