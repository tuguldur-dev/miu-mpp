package Lab6.prob4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Order {
    private LocalDate orderDate;
    private List<Item> items;
    private Customer customer;

    //use a factory method
    Order(LocalDate orderDate, Customer customer) {
        this.orderDate = orderDate;
        items = new ArrayList<Item>();
        this.customer = customer;
    }

    public static Order newOrder(Customer cust, LocalDate date) {
        if (cust == null) throw new NullPointerException("Null customer");
        Order ord = new Order(date, cust);
        cust.addOrder(ord);
        return ord;
    }

    void addItem(Item item) {
        items.add(item);
    }

    @Override
    public String toString() {
        return orderDate + ": " +
                items.toString();
    }
}
