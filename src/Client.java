public class Client extends User {
    String profilePhotoPath;
    public Client(String firstName, String lastName, String email, String password, int phoneNumber,String profilePhotoPath) {
        super(firstName, lastName, email, password, phoneNumber);
        this.profilePhotoPath = profilePhotoPath;
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
