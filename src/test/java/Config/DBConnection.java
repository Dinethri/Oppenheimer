package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;
    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "user";
    private static final String password = "userpassword";
    private DBConnection() {
        // Private constructor to prevent instantiation
    }

    public static Connection getInstance() {
        if (connection == null) {
            synchronized (DBConnection.class) {
                if (connection == null) {
                    try {
                        // Load the MySQL JDBC driver
                        Class.forName("com.mysql.jdbc.Driver");

                        // Set up the database connection

                        connection = DriverManager.getConnection(jdbcUrl, username, password);
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }
}