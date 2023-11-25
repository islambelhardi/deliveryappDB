public class Agent extends User {
    String ipAdress;

    public Agent(String firstName, String lastName, String email, String password, int phoneNumber, String ipAdress) {
        super(firstName, lastName, email, password, phoneNumber);
        this.ipAdress = ipAdress;
    }

    @Override
    public void updateUser(String firstName, String lastName, String email, String password, int phoneNumber) {
        // TODO implement here
    }

    @Override
    public void updatePassword(String oldPassword, String newPassword) {
        // TODO implement here
    }

    public void createClient(Client client) {
        // TODO implement here
    }

    public void createDeliveryGuy(DeliveryGuy deliveryGuy) {
        // TODO implement here
    }

    public void createItem(Item item) {
        // TODO implement here
    }
}
