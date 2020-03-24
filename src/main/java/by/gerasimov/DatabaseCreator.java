package by.gerasimov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;

public class DatabaseCreator {

    private static final String CREATE_TABLES_PATH =
        System.getProperty("user.dir") + "/src/main/resources/mySQL/create_tables.sql";
    private static final String INSERT_INTO_TABLES_PATH =
        System.getProperty("user.dir") + "/src/main/resources/mySQL/insert/";
    private static final String INSERT_INTO_TABLES_ORDER_PATH = INSERT_INTO_TABLES_PATH + "insert_order.txt";
    private static final Logger LOGGER = Logger.getLogger(DatabaseCreator.class);
    private static ConnectionManager connectionManager = new ConnectionManagerJDBC();
    private Statement statement;

    public void createTables() {
        executeUpdate(getCreationQueryFromFile());
    }

    public void insertIntoTables() {
        executeUpdate(getInsertQueryFromFile());
    }

    private void executeUpdate(String queriesLine) {
        try (Connection connection = connectionManager.getConnection()) {
            statement = connection.createStatement();
            String[] queries = queriesLine.split(";");
            for (String query : queries) {
                executeUpdateWithLog(query);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void executeUpdateWithLog(String query) {
        try {
            LOGGER.info(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    private String getCreationQueryFromFile() {
        StringBuilder result = new StringBuilder();
        try {
            Files.lines(Paths.get(CREATE_TABLES_PATH)).forEach(result::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    private String getInsertQueryFromFile() {
        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(INSERT_INTO_TABLES_ORDER_PATH))) {
            String path;
            while ((path = br.readLine()) != null) {
                Files.lines(Paths.get(INSERT_INTO_TABLES_PATH + path)).forEach(result::append);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
