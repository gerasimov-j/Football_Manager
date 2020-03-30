package by.gerasimov.hibernate.dao;

import by.gerasimov.hibernate.model.Country;

public class CountryDao extends Dao {

    @Override
    public Class<Country> getEntityClass() {
        return Country.class;
    }
}
