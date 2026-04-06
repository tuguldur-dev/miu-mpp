package Lab6.prob4;

import java.time.LocalDate;

public class CustOrderFactory {
    private CustOrderFactory() {
    }

    public static Customer createCustomer(String name) {
        return new Customer(name);
    }

    public static Order createOrder(Customer customer, LocalDate date) {
        Order order = new Order(date, customer);
        customer.addOrder(order);
        return order;
    }

    public static Item createItem(String name) {
        return new Item(name);
    }

    public static void addItemToOrder(Order order, String itemName) {
        Item item = new Item(itemName);
        order.addItem(item);
    }
}
