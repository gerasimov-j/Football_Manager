package by.gerasimov.alternative;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dao_mysql extends dao_base {

    private final String DATABASE_CREATE = "CREATE DATABASE IF NOT EXISTS %s " +
        "CHARACTER SET utf8 " +
        "COLLATE utf8_general_ci ";
    private final String DROP_DATABASE = "DROP DATABASE %s";
    private Connection connection = null;

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public dao_mysql() {
        super("com.mysql.jdbc.Driver");
    }

    ;

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @Override
    public void setURL(String host, String database, int port) {
        if (database.length() > 0) {
            this.url = "jdbc:mysql://" + host + ":" + port + "/" + database;
        } else {
            this.url = "jdbc:mysql://" + host + ":" + port;
        }
    }

    ;

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @Override
    public Connection getConnection() {
        return connection;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @Override
    public void Connect(String login, String password) {
        super.Connect(login, password);
        try {
            connection = DriverManager.getConnection(url, properties);
        } catch (SQLException e) {
            connection = null;
        }
    }

    ;

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @Override
    public boolean createSchema(final String schema) {
        return execSQL(String.format(DATABASE_CREATE, schema));
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @Override
    public boolean dropSchema(final String schema) {
        return execSQL(String.format(DROP_DATABASE, schema));
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}