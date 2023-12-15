package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                String url = "jdbc:oracle:thin:@//localhost:1521/xe"; // Replace with your database details
                String username = "delivery";
                String password = "root";

                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connected to database!");
            } catch (SQLException e) {
                System.out.println("Connection failed! Check console for errors.");
                e.printStackTrace();
            }
            return connection;
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}