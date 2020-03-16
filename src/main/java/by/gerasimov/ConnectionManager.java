package by.gerasimov;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String URL = "jdbc:mysql://localhost:3306/userBankList?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "1111";

    public static Connection getConnection() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}