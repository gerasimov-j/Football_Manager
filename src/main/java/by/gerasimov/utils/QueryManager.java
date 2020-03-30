package by.gerasimov.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class QueryManager {

    private static final String CREATE_TABLES_PATH =
        System.getProperty("user.dir") + "/src/main/resources/mySQL/create_tables.sql";
    private static final String INSERT_INTO_TABLES_PATH =
        System.getProperty("user.dir") + "/src/main/resources/mySQL/insert/";
    private static final String INSERT_INTO_TABLES_ORDER_PATH = INSERT_INTO_TABLES_PATH + "insert_order.txt";

    protected static String getCreationQueryFromFile() {
        StringBuilder result = new StringBuilder();
        try {
            Files.lines(Paths.get(CREATE_TABLES_PATH)).forEach(result::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    protected static String getInsertQueryFromFile() {
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
