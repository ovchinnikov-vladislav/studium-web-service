package ru.kamchatgtu.studium.DAO;

import org.hibernate.Session;
import ru.kamchatgtu.studium.engine.HibernateUtil;
import java.sql.SQLException;

/**
 * Абстрактный класс {@code DAOAbstr} реализует следующие запросы к БД:
 * <br>1. Добавление объекта в БД
 * <br>2. Удаление объекта из БД
 * <br>3. Обновление объекта в БД
 * @author Овчинников В.А.
 * @param <T> тип объекта, хранимого в БД
 */
public abstract class DAOAbstr<T> implements DAO<T> {

    /**
     * Метод добавление объекта в БД
     * @param t объект, добавляемый в БД
     * @return возращает true или false в случае успеха
     * @throws SQLException
     */
    public boolean add(T t) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();
            return true;
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод удаление объекта из БД
     * @param t объект, удаляемый из БД
     * @return возращает true или false в случае успеха
     * @throws SQLException
     */
    public boolean remove(T t) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(t);
            session.getTransaction().commit();
            return true;
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод обновления объекта в БД
     * @param t объект, обновляемый в БД
     * @return возращает true или false в случае успеха
     * @throws SQLException
     */
    public boolean update(T t) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(t);
            session.getTransaction().commit();
            return true;
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }
}
