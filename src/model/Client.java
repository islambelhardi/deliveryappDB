package model;
import java.util.*;

public class Client extends User {
    String profilePhotoPath;
    private Set<Order> orders;

    public Client(int id,String firstName, String lastName, String email, String password, int phoneNumber,
            String profilePhotoPath) {
        super(id,firstName, lastName, email, password, phoneNumber);
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

    // getters and setters
    public String getProfilePhotoPath() {
        return profilePhotoPath;
    }
    public void setProfilePhotoPath(String profilePhotoPath) {
        this.profilePhotoPath = profilePhotoPath;
    }

    public int getId(){
        return id;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public int getPhoneNumber(){
        return phoneNumber;
    }
    
}
