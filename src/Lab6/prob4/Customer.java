package Lab6.prob4;

import java.util.ArrayList;
import java.util.List;

class Customer {
	private String name;
	private List<Order> orders;
	protected Customer(String name) {
		this.name = name;
		orders = new ArrayList<Order>();	
	}
	public void addOrder(Order order) {
		orders.add(order);
	}
	public String getName() {
		return name;
	}
	public List<Order> getOrders() {
		return orders;
	}
}
