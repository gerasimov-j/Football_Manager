package by.gerasimov;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreator {

    public void create() {
        Connection connection = ConnectionManager.getConnection();
        try (Statement st = connection.createStatement()) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
