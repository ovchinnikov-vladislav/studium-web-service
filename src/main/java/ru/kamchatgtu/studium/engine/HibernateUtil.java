package ru.kamchatgtu.studium.engine;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import java.sql.SQLException;

/**
 * Реализует singleton для {@code SessionFactory}
 * @author Овчинников В.А.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory = null;

    private HibernateUtil() {}

    /**
     * Метод возрата singleton объекта класса {@code SessionFactory} с настроенной конфигурацией
     * @return возращает singleton объекта класса {@code SessionFactory} с настроенной конфигурацией
     * @throws SQLException
     */
    public static synchronized SessionFactory getSessionFactory() throws SQLException {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            } catch (Exception exc) {
                exc.printStackTrace();
                throw new SQLException(exc);
            }
        }
        return sessionFactory;
    }
}
