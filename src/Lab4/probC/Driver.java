package Lab4.probC;

import java.time.LocalDate;
import java.util.List;

public class Driver {
    static void main(String[] args) {

        Hourly hourly = new Hourly("E001", 20.0, 40.0);
        hourly.print();
        Paycheck hourlyCheck = hourly.calcCompensation(4, 2026);
        hourlyCheck.print();
        System.out.printf("Hourly Net Pay: $%.2f\n", hourlyCheck.getNetPay());

        Salaried salaried = new Salaried("E002", 5000.0);
        salaried.print();
        Paycheck salariedCheck = salaried.calcCompensation(4, 2026);
        salariedCheck.print();
        System.out.printf("Salary Net Pay: $%.2f\n", salariedCheck.getNetPay());

        List<Order> orders = List.of(
                new Order("ORD001", LocalDate.of(2026, 3, 5), 1000.0),
                new Order("ORD002", LocalDate.of(2026, 3, 15), 2500.0),
                new Order("ORD003", LocalDate.of(2026, 3, 28), 500.0),
                new Order("ORD004", LocalDate.of(2026, 4, 1), 9999.0)
        );

        Commissioned commissioned = new Commissioned("E003", 0.10, 1500.0, orders);
        commissioned.print();
        Paycheck commCheck = commissioned.calcCompensation(4, 2026);
        commCheck.print();

        System.out.printf("Commissioned Net Pay: $%.2f\n", commCheck.getNetPay());
    }
}