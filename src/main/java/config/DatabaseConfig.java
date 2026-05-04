package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final String MYSQL_HOST = System.getenv("MYSQL_HOST");
    private static final String MYSQL_PORT = System.getenv("MYSQL_PORT");
    private static final String MYSQL_USER = System.getenv("MYSQL_USER");
    private static final String MYSQL_PASSWORD = System.getenv("MYSQL_PASSWORD");
    private static final String MYSQL_DATABASE = System.getenv("MYSQL_DATABASE");

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            String url = "jdbc:mysql://" + MYSQL_HOST + ":" + MYSQL_PORT + "/" + MYSQL_DATABASE;
            connection = DriverManager.getConnection(url, MYSQL_USER, MYSQL_PASSWORD);
        }
        return connection;
    }
}