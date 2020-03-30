package by.gerasimov;

import by.gerasimov.hibernate.dao.CountryDao;
import by.gerasimov.hibernate.dao.Dao;
import by.gerasimov.hibernate.model.Country;
import by.gerasimov.utils.DatabaseCreator;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Dao countryDao = new CountryDao();
        List<Country> countries = countryDao.getAll();
        for (Country country : countries) {
            System.out.println(country + " : " + country.getStadiums());
        }
    }

    private static void createDB() {
        DatabaseCreator creator = new DatabaseCreator();
        creator.createTables();
        creator.insertIntoTables();
    }
}
