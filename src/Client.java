import java.util.*;

public class Client extends User {
    String profilePhotoPath;
    private Set<Order> orders;

    public Client(String firstName, String lastName, String email, String password, int phoneNumber,
            String profilePhotoPath) {
        super(firstName, lastName, email, password, phoneNumber);
        this.profilePhotoPath = profilePhotoPath;
        orders = new HashSet<Order>();
    }

    public void addOrder(Order order) {
        if (!getOrders().contains(order)) {
            if (order.getClient() != null)
                order.removeClient();
            order.setClient(this);
            getOrders().add(order);
        }
    }

    public void removeOrder(Order order) {
        if (getOrders().contains(order)) {
            getOrders().remove(order);
            order.setClient(null);
        }
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public void updateUser(String firstName, String lastName, String email, String password, int phoneNumber) {
        // TODO implement here
    }

    @Override
    public void updatePassword(String oldPassword, String newPassword) {
        // TODO implement here
    }

    public void createOrder(Order order) {
        // TODO implement here
    }

    public void confirmOrder(Order order) {
        // TODO implement here
    }

    public void review(Order order) {
        // TODO implement here
    }
}
