package dao;

import model.Agent;
import database.DatabaseConnection;
import java.util.List;
import java.util.Optional;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AgentDao implements Dao<Agent> {

    private Connection connection;

    public AgentDao() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public Optional<Agent> get(int id) {
        Optional<Agent> userOptional = Optional.empty();
        String query = "SELECT * FROM Agent WHERE id = ?"; // Assuming your user table is named 'users'

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
                String ipAdress = resultSet.getString("ip_adress");
                // Create a User object with retrieved values
                Agent user = new Agent(userId, firstName, lastName, email, password, phoneNumber, ipAdress);
                userOptional = Optional.of(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userOptional;
    }

    @Override
    public List<Agent> getAll() {
        // TODO implement here
        return null;
    }

    @Override
    public void save(Agent agent) {
        String query = "INSERT INTO Agent (firstname, lastname, email, password, phone_number, ip_adress) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, agent.getFirstName());
            preparedStatement.setString(2, agent.getLastName());
            preparedStatement.setString(3, agent.getEmail());
            preparedStatement.setString(4, agent.getPassword());
            preparedStatement.setInt(5, agent.getPhoneNumber());
            preparedStatement.setString(6, agent.getIpAdress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Agent agent, String[] params) {

    }

    @Override
    public void delete(Agent agent) {
        String query = "DELETE FROM Agent WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, agent.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
