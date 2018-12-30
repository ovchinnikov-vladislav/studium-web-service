package ru.kamchatgtu.studium.DAO.impl;

import org.hibernate.Session;
import ru.kamchatgtu.studium.engine.HibernateUtil;
import ru.kamchatgtu.studium.entity.Test;

import java.sql.SQLException;
import java.util.Collection;

public class TestDAOImpl extends DAOImpl<Test> {

    @Override
    public Test get(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.load(Test.class, id);
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public Collection search(Test value) throws SQLException {
        // TODO: поиск по тестам
        return null;
    }

    @Override
    public Collection getAll() throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Test").list();
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new SQLException();
        }
    }

    public Collection searchBySubject(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Test where subject.idSubject = :id").setParameter("id", id).list();
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new SQLException();
        }
    }
}
