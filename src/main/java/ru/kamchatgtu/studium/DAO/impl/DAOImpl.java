package ru.kamchatgtu.studium.DAO.impl;

import org.hibernate.Session;
import ru.kamchatgtu.studium.DAO.DAO;
import ru.kamchatgtu.studium.engine.HibernateUtil;

import java.sql.SQLException;

public abstract class DAOImpl<T> implements DAO<T> {
    public boolean add(T t) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    public boolean remove(T t) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(t);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    public boolean update(T t) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(t);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }
}
