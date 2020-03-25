package by.gerasimov.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class CountryService {

    private EntityManagerFactory factory;
    private EntityManager entityManager;

    public CountryService() {
        factory = Persistence.createEntityManagerFactory("Football_manager");
        entityManager = factory.createEntityManager();
    }

    public void begin() {
        entityManager.getTransaction().begin();
    }

    public void end() {
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }

    public Country add(Country country) {
        return entityManager.merge(country);
    }

    public void delete(long id) {
        Country country = entityManager.find(Country.class, id);
        if (country != null) {
            entityManager.remove(country);
        }
    }

    public Country get(long id) {
        return entityManager.find(Country.class, id);
    }

    public void update(Country country) {
        entityManager.merge(country);
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
