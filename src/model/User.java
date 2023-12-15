package model;
public abstract class User {
    String firstName, lastName, email, password;
    int phoneNumber,id;

    public User(int id, String firstName, String lastName, String email, String password, int phoneNumber) {
        this.id = id;
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


    // Getters and Setters
    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
}
