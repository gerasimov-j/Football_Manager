package by.gerasimov;

public class Runner {

    public static void main(String[] args) {

    }

    private void createDB() {
        DatabaseCreator creator = new DatabaseCreator();
        creator.createTables();
        creator.insertIntoTables();
    }
}
