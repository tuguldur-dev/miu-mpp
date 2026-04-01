package Lab2.prob2B;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderNum;
    private List<OrderLine> orderLines;

    public Order(int orderNum) {
        this.orderNum = orderNum;
        this.orderLines = new ArrayList<>();
        this.orderLines.add(new OrderLine(this));
    }

    public void addOrderLine() {
        orderLines.add(new OrderLine(this));
    }

    public int getOrderNum() {
        return orderNum;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNum=" + orderNum +
                ", orderLines=" + orderLines +
                '}';
    }
}
