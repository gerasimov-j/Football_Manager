package by.gerasimov.hibernate.queries;

import static org.junit.Assert.*;

import by.gerasimov.hibernate.dao.Dao;
import by.gerasimov.hibernate.model.Country;
import org.junit.Test;

public class QueryBuilderTest {

    Dao dao = new Dao();
    QueryBuilder builder = new MySQLQueryBuilder();

    @Test
    public void getBelarus() {
        builder.clear();
        builder = builder.select().setTable("countries").where()
            .equal("name", "Беларусь").and()
            .equal("tag_name", "BLR");
        Country country = dao.getFirst(Country.class, builder.getQuery());
        builder.clear();
        assertEquals(country.getName(), "Беларусь");
        assertEquals(country.getTagName(), "BLR");
    }

}