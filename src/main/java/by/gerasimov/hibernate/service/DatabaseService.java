package by.gerasimov.hibernate.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseService {

    private EntityManagerFactory factory;
    private EntityManager entityManager;

    public DatabaseService() {
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

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
