package Lab2.prob2B;

public class OrderLine {
    private Order order;

    public OrderLine(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "orderNum=" + order.getOrderNum() +
                '}';
    }
}