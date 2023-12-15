package test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.DeliveryGuyDao;
import model.DeliveryGuy;
import database.DatabaseConnection;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

public class DeliveryGuyDaoTest {
    private static Connection connection;
    private static DeliveryGuyDao userDao;

    @BeforeClass
    public static void setUp() {
        connection = DatabaseConnection.getConnection(); // Establish a connection
        userDao = new DeliveryGuyDao();
    }

    @AfterClass
    public static void tearDown() {
        // Close the connection after all tests are done
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetUserById() {
        // Test the get method in UserDao for retrieving a user by ID
        int userIdToRetrieve = 1; // Replace with an existing user ID from your database
        assertTrue(userDao.get(userIdToRetrieve).isPresent());
    }

    @Test
    public void testInsertUser() {
        // Test the save method in UserDao for inserting a new user
        // Replace the parameters below with your own values
        String firstName = "John";
        String lastName = "Doe";
        String email = "john@gmail.com";
        String password = "password";
        int phoneNumber = 123456789;
        DeliveryGuy.Status status = DeliveryGuy.Status.inactive;
        DeliveryGuy user = new DeliveryGuy(3, firstName, lastName, email, password, phoneNumber, status);
        userDao.save(user);
        assertTrue(userDao.get(user.getId()).isPresent());
    }

    @Test
    public void testDeleteUser() {
        // Test the delete method in UserDao for deleting a user
        int userIdToDelete = 3; // Replace with an existing user ID from your database
        userDao.delete(userDao.get(userIdToDelete).get());
        assertTrue(!userDao.get(userIdToDelete).isPresent());
    }
}