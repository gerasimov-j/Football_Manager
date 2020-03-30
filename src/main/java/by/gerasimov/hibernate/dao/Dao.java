package by.gerasimov.hibernate.dao;

import by.gerasimov.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class Dao {

    public abstract <T> Class<T> getEntityClass();

    public <T> List<T> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return (List<T>) session.createQuery("from " + getEntityClass().getSimpleName(), getEntityClass()).list();
        }
    }

    public <T> List<T> getList(String query) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createSQLQuery(query).addEntity(getEntityClass()).list();
        }
    }

    public <T> T getFirst(String query) {
        return (T) getList(query).get(0);
    }

    public <T> void save(T object) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public <T> void delete(T object) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void executeSQLQuery(String query) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createSQLQuery(query).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
