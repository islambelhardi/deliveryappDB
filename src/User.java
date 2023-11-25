public abstract class User {
    String firstName, lastName, email, password;
    int phoneNumber;

    public User(String firstName, String lastName, String email, String password, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public void updateUser(String firstName, String lastName, String email, String password, int phoneNumber) {
        // TODO implement here
    }

    public void updatePassword(String oldPassword, String newPassword) {
        // TODO implement here
    }
}
