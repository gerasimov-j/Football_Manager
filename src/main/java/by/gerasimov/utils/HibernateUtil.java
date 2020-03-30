package by.gerasimov.utils;

import by.gerasimov.hibernate.model.Country;
import by.gerasimov.hibernate.model.Season;
import by.gerasimov.hibernate.model.Stadium;
import by.gerasimov.hibernate.model.TeamType;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateUtil {

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static void buildSessionFactory() {
        if (sessionFactory == null) {
            try {
                StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
                Map<String, Object> settings = new HashMap<>();
                settings.put(Environment.DRIVER, ConnectionManager.getDriver());
                settings.put(Environment.URL, ConnectionManager.getURL());
                settings.put(Environment.USER, ConnectionManager.getUser());
                settings.put(Environment.PASS, ConnectionManager.getPassword());
                settings.put(Environment.HBM2DDL_AUTO, "update");
                settings.put(Environment.ENABLE_LAZY_LOAD_NO_TRANS, true);
//                settings.put(Environment.SHOW_SQL, true);
                registryBuilder.applySettings(settings);
                registry = registryBuilder.build();
                MetadataSources sources = new MetadataSources(registry);
                sources.addAnnotatedClass(Country.class);
                sources.addAnnotatedClass(Stadium.class);
                sources.addAnnotatedClass(Season.class);
                sources.addAnnotatedClass(TeamType.class);
                Metadata metadata = sources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {
                shutdown();
                e.printStackTrace();
            }
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}