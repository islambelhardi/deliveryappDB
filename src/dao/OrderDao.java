package dao;

import model.Order;
import database.DatabaseConnection;
import java.util.Optional;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class OrderDao implements Dao<Order> {

    private Connection connection;

    public OrderDao() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public List<Order> getAll() {
        // TODO implement here
        return null;
    }

    @Override
    public Optional<Order> get(int id) {
        Optional<Order> orderOptional = Optional.empty();
        String query = "SELECT * FROM Order WHERE id = ?"; // Assuming your user table is named 'users'

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int orderId = resultSet.getInt("id");
                String review = resultSet.getString("review");
                Date createdAt = resultSet.getDate("created_at");
                Date updatedAt = resultSet.getDate("updated_at");
                Date confirmedAt = resultSet.getDate("confirmed_at");
                int evaluation = resultSet.getInt("evaluation");
                // Create a User object with retrieved values
                Order order = new Order(orderId, review, createdAt, updatedAt, confirmedAt, evaluation);
                orderOptional = Optional.of(order);
                return orderOptional;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return orderOptional;
    }

    @Override
    public void save(Order order) {
        // TODO implement here
    }

    @Override
    public void update(Order order, String[] params) {
        // TODO implement here
    }

    @Override
    public void delete(Order order) {
        // TODO implement here
        String query = "DELETE FROM Order WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, order.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}