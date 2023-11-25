public class DeliveryGuy extends User {
    public static enum Status {
        active,
        inactive
    }

    Status status;

    public DeliveryGuy(String firstName, String lastName, String email, String password, int phoneNumber,
            Status status) {
        super(firstName, lastName, email, password, phoneNumber);
        this.status = status;
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
