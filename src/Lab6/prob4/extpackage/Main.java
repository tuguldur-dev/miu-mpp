package Lab6.prob4.extpackage;

import java.time.LocalDate;

import Lab6.prob4.CustOrderFactory;
import Lab6.prob4.Customer;
import Lab6.prob4.Order;

public class Main {
	public static void main(String[] args) {
		Customer cust = CustOrderFactory.createCustomer("Bob");
		Order order = CustOrderFactory.createOrder(cust, LocalDate.now());
		CustOrderFactory.addItemToOrder(order,"Shirt");
		CustOrderFactory.addItemToOrder(order,"Laptop");

		Order order2 = CustOrderFactory.createOrder(cust, LocalDate.now());
		CustOrderFactory.addItemToOrder(order2, "Pants");
		CustOrderFactory.addItemToOrder(order2, "Knife set");

		System.out.println(cust.getOrders());
	}
}

		
