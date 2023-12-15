package model;
import java.util.Set;
import java.util.HashSet;
public class Item {
    String name, description;
    Double price;

    public Item(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.orderLines = new HashSet<OrderLine>();
    }
    private Set<OrderLine> orderLines;
    public void addOrderLine(OrderLine orderLine) {
        if (!getOrderLines().contains(orderLine)) {
            getOrderLines().add(orderLine);
        }
    }
    public void removeOrderLine(OrderLine orderLine) {
        if (getOrderLines().contains(orderLine)) {
            getOrderLines().remove(orderLine);
        }
    }
    public Set<OrderLine> getOrderLines() {
        return orderLines;
    }
    public void setOrderLines(Set<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
