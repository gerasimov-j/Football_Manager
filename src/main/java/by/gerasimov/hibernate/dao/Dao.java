package by.gerasimov.hibernate.dao;

import by.gerasimov.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Dao {

    public <T> List<T> getList(Class<T> tClass, String query) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createSQLQuery(query).addEntity(tClass).list();
        }
    }

    public <T> T getFirst(Class<T> tClass, String query) {
        return getList(tClass, query).get(0);
    }

    public void createQuery(String query) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createSQLQuery(query);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
