package by.gerasimov;

import by.gerasimov.hibernate.dao.CountryDao;
import by.gerasimov.hibernate.dao.Dao;
import by.gerasimov.hibernate.model.Country;
import by.gerasimov.hibernate.queries.MySQLQueryBuilder;
import by.gerasimov.hibernate.queries.QueryBuilder;
import by.gerasimov.utils.DatabaseCreator;

public class Runner {

    public static void main(String[] args) {
        QueryBuilder builder = new MySQLQueryBuilder().select().setTable("countries").where()
            .equal("name", "Estonia").or()
            .equal("name", "1");
        Dao dao = new CountryDao();
        System.out.println(dao.getList(Country.class, builder.getQuery()));
    }

    private static void createDB() {
        DatabaseCreator creator = new DatabaseCreator();
        creator.createTables();
        creator.insertIntoTables();
    }
}
