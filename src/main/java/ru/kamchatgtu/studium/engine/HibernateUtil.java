package ru.kamchatgtu.studium.engine;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

import java.sql.SQLException;

public class HibernateUtil {

    private static SessionFactory sessionFactory = null;

    private HibernateUtil() {}

    public static synchronized SessionFactory getSessionFactory() throws SQLException {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            } catch (Exception exc) {
                exc.printStackTrace();
                throw new SQLException();
            }
        }
        return sessionFactory;
    }
}
