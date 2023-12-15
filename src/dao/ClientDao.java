package dao;

import model.Client;
import database.DatabaseConnection;
import java.util.List;
import java.util.Optional;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientDao implements Dao<Client> {

    private Connection connection;

    public ClientDao() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public Optional<Client> get(int id) {
        Optional<Client> userOptional = Optional.empty();
        String query = "SELECT * FROM Client WHERE id = ?"; // Assuming your user table is named 'users'

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                int phoneNumber = resultSet.getInt("phone_number");
                String profilePhotoPath = resultSet.getString("profile_photo_path");
                // Create a User object with retrieved values
                Client user = new Client(userId, firstName, lastName, email, password, phoneNumber, profilePhotoPath);
                userOptional = Optional.of(user);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userOptional;
    }

    @Override
    public List<Client> getAll() {
        // TODO implement here
        return null;
    }

    @Override
    public void save(Client client) {
        String query = "INSERT INTO Client (firstname, lastname, email, password, phone_number, profile_photo_path) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setString(3, client.getEmail());
            preparedStatement.setString(4, client.getPassword());
            preparedStatement.setInt(5, client.getPhoneNumber());
            preparedStatement.setString(6, client.getProfilePhotoPath());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Client client, String[] params) {
        // TODO implement here
    }

    @Override
    public void delete(Client client) {
        String query = "DELETE FROM Client WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, client.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}