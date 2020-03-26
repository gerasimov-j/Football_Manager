package by.gerasimov.hibernate.service;

import by.gerasimov.hibernate.model.Country;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class CountryService extends DatabaseService {

    public Country add(Country country) {
        return getEntityManager().merge(country);
    }

    public void delete(long id) {
        Country country = getEntityManager().find(Country.class, id);
        if (country != null) {
            getEntityManager().remove(country);
        }
    }

    public Country get(long id) {
        return getEntityManager().find(Country.class, id);
    }

    public void update(Country country) {
        getEntityManager().merge(country);
    }

    public void show(long id) {
        String sql = "SELECT c from Country c where c.id = '" + id + "'";
        Query query = getEntityManager().createQuery(sql);
        if (query.getResultList().size() > 0) {
            Country country = (Country) query.getSingleResult();
            System.out.println(country);
        }
    }

    public List<Country> getAll() {
        TypedQuery<Country> namedQuery = getEntityManager().createNamedQuery("Country.getAll", Country.class);
        return namedQuery.getResultList();
    }
}
