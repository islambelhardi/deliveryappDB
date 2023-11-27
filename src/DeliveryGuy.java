import java.util.*;

public class DeliveryGuy extends User {
    public static enum Status {
        active,
        inactive
    }

    Status status;
    private Set<Order> orders;

    public DeliveryGuy(String firstName, String lastName, String email, String password, int phoneNumber,
            Status status) {
        super(firstName, lastName, email, password, phoneNumber);
        this.status = status;
        this.orders = new HashSet<Order>();
    }

    public void addOrder(Order order) {
        if (!getOrders().contains(order))
            getOrders().add(order);
    }

    public void removeOrder(Order order) {
        if (getOrders().contains(order))
            getOrders().remove(order);
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public void confirmDelivery(Order order) {
        // TODO implement here
    }

    public void getMyOrders() {
        // TODO implement here
    }

    @Override
    public void updateUser(String firstName, String lastName, String email, String password, int phoneNumber) {
        // TODO implement here
    }

    @Override
    public void updatePassword(String oldPassword, String newPassword) {
        // TODO implement here
    }
}
