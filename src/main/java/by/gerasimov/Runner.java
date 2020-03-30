package by.gerasimov;

import by.gerasimov.utils.DatabaseCreator;

public class Runner {

    public static void main(String[] args) {
    }

    private static void createDB() {
        DatabaseCreator creator = new DatabaseCreator();
        creator.createTables();
        creator.insertIntoTables();
    }
}
