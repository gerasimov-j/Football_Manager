package by.gerasimov;

public class Runner {

    public static void main(String[] args) {
        DatabaseCreator creator = new DatabaseCreator();
        creator.createTables();
        creator.insertIntoTables();
    }
}
