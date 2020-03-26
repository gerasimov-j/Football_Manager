package by.gerasimov.hibernate.dao;

import by.gerasimov.hibernate.model.Country;
import java.util.List;
import org.junit.Test;

public class CountryDaoTest {

    CountryDao dao = new CountryDao();

    @Test
    public void saveCountry() {
        Country country = new Country();
        country.setName("Estonia");
        country.setTagName("EST");
        dao.save(country);
    }

    @Test
    public void getCountries() {
        List<Country> countries = dao.getAll();
        for (Country c : countries) {
            System.out.println(c);
        }
    }
}