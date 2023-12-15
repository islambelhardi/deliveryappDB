
package dao;

import model.DeliveryGuy;
import model.DeliveryGuy.Status;
import database.DatabaseConnection;
import java.util.List;
import java.util.Optional;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeliveryGuyDao implements Dao<DeliveryGuy> {


    private Connection connection;
    
    public DeliveryGuyDao() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public Optional<DeliveryGuy> get(int id) {
        Optional<DeliveryGuy> userOptional = Optional.empty();
        String query = "SELECT * FROM Delivery_Guy WHERE id = ?"; // Assuming your user table is named 'users'

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                int phoneNumber = resultSet.getInt("phone_number");
                String statusString = resultSet.getString("status");
                Status status = Status.getStatusFromString(statusString);
                // Create a User object with retrieved values
                DeliveryGuy user = new DeliveryGuy(userId, firstName, lastName, email, password, phoneNumber, status);
                userOptional = Optional.of(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userOptional;
    }

    @Override
    public List<DeliveryGuy> getAll() {
        // TODO implement here
        return null;
    }

    @Override
    public void save(DeliveryGuy deliveryGuy) {
        String query = "INSERT INTO Delivery_Guy (firstname, lastname, email, password, phone_number, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, deliveryGuy.getFirstName());
            preparedStatement.setString(2, deliveryGuy.getLastName());
            preparedStatement.setString(3, deliveryGuy.getEmail());
            preparedStatement.setString(4, deliveryGuy.getPassword());
            preparedStatement.setInt(5, deliveryGuy.getPhoneNumber());
            preparedStatement.setString(6, deliveryGuy.getStatus().toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(DeliveryGuy deliveryGuy, String[] params) {
        // TODO implement here
    }

    @Override
    public void delete(DeliveryGuy deliveryGuy) {
        String query = "DELETE FROM Delivery_Guy WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, deliveryGuy.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
