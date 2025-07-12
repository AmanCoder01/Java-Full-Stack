package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String dbUrl = "jdbc:mysql://localhost3636/garage";
    private static final String dbUsername = "root";
    private static final String dbPassword = "1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
    }
}
