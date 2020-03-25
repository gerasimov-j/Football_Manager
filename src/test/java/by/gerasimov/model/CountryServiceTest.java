package by.gerasimov.model;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;

public class CountryServiceTest {

    CountryService service = new CountryService();

    @Test
    public void add() {
        Country country = new Country();
        country.setName("Estonia");
        country.setTagName("EST");
        Country countryFromDB = service.add(country);
        assertEquals(country.getName(), countryFromDB.getName());
        assertEquals(country.getTagName(), countryFromDB.getTagName());
    }

    @Test
    public void get() {
        service.delete(100);
        assertNull(service.get(100));
        Country country = new Country();
        country.setId(1);
        country.setName("Беларусь");
        country.setTagName("BLR");
        assertEquals(country, service.get(1));
    }

    @Test
    public void delete() {
        Country country = new Country(100, "1", "2");
        service.add(country);
        service.delete(100);
        assertNull(service.get(100));
    }

    @Test
    public void show() {
        service.show(100);
    }

    @Test
    public void getAll() {
        Country country1 = new Country();
        country1.setName("Latvia");
        country1.setTagName("LAT");
        service.add(country1);
        List<Country> countries = service.getAll();
        for(Country c : countries) {
            System.out.println(c);
        }
    }
}