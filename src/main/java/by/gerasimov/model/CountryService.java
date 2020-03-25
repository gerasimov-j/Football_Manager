package by.gerasimov.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class CountryService {

    private EntityManager entityManager;

    public CountryService() {
        entityManager = Persistence.createEntityManagerFactory("Football_manager").createEntityManager();
    }

    public Country add(Country country) {
        entityManager.getTransaction().begin();
        Country countryFromDB = entityManager.merge(country);
        entityManager.getTransaction().commit();
        return countryFromDB;
    }

    public void delete(long id) {
        entityManager.getTransaction().begin();
        Country country = entityManager.find(Country.class, id);
        if (country != null) {
            entityManager.remove(country);
        }
        entityManager.getTransaction().commit();
    }

    public Country get(long id) {
        return entityManager.find(Country.class, id);
    }

    public void update(Country country) {
        entityManager.getTransaction().begin();
        entityManager.merge(country);
        entityManager.getTransaction().commit();
    }

    public void show(long id) {
        String sql = "SELECT c from Country c where c.id = '" + id + "'";
        Query query = entityManager.createQuery(sql);
        if (query.getResultList().size() > 0) {
            Country country = (Country) query.getSingleResult();
            System.out.println(country);
        }
    }
    public List<Country> getAll() {
        TypedQuery<Country> namedQuery = entityManager.createNamedQuery("Country.getAll", Country.class);
        return namedQuery.getResultList();
    }
}
