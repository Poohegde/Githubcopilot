package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTests {

    private Connection connection;

    @BeforeClass
    public void setUp() {
        try {
            connection = DatabaseUtils.getConnection();
        } catch (SQLException e) {
            Assert.fail("Unable to connect to database: " + e.getMessage());
        }
    }

    @Test
    public void testRegistrationData() {
        String expectedUsername = "testuser"; // Replace with actual test data
        String expectedEmail = "test@example.com"; // Replace with actual test data

        String query = "SELECT * FROM RegistrationDetails WHERE email = '" + expectedEmail + "'";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            Assert.assertTrue(resultSet.next(), "No registration data found for the user.");
            ResultSetMetaData metaData = resultSet.getMetaData();
            boolean hasUsername = false;
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                if ("username".equalsIgnoreCase(metaData.getColumnName(i))) {
                    hasUsername = true;
                    break;
                }
            }
            if (hasUsername) {
                Assert.assertEquals(resultSet.getString("username"), expectedUsername, "Username does not match.");
            }
            Assert.assertEquals(resultSet.getString("email"), expectedEmail, "Email does not match.");
        } catch (SQLException e) {
            Assert.fail("Database query failed: " + e.getMessage());
        }
    }

    // Additional database tests can be added here

    @AfterClass
    public void tearDown() {
        DatabaseUtils.closeConnection(connection);
    }
}