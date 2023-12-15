package model;
import java.util.*;

public class DeliveryGuy extends User {
    public static enum Status {
        active,inactive;
        // add valueof method
        public static Status getStatusFromString(String statusString) {
            try {
                return Status.valueOf(statusString.toUpperCase());
            } catch (IllegalArgumentException e) {
                // If the string doesn't match any enum value, handle the exception or provide a default value
                return inactive; // Replace DEFAULT_STATUS with your default value
            }
        }
    }

    Status status;
    private Set<Order> orders;

    public DeliveryGuy(int id ,String firstName, String lastName, String email, String password, int phoneNumber,
            Status status) {
        super(id,firstName, lastName, email, password, phoneNumber);
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

    // getters and setters
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId(){
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber = phoneNumber;
    }
}
