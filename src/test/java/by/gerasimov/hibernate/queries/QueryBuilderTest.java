package by.gerasimov.hibernate.queries;

import static org.junit.Assert.*;

import by.gerasimov.hibernate.dao.CountryDao;
import by.gerasimov.hibernate.dao.Dao;
import by.gerasimov.hibernate.model.Country;
import org.junit.Test;

public class QueryBuilderTest {

    QueryBuilder builder = new MySQLQueryBuilder();

    @Test
    public void getBelarus() {
        builder.clear();
        builder = builder.select().setTable("countries").where()
            .equal("name", "Беларусь").and()
            .equal("tag_name", "BLR");
        Dao dao = new CountryDao();
        Country country = dao.getFirst(builder.getQuery());
        builder.clear();
        assertEquals(country.getName(), "Беларусь");
        assertEquals(country.getTagName(), "BLR");
    }

}