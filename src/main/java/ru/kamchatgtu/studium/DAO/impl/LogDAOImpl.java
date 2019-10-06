package ru.kamchatgtu.studium.DAO.impl;

import org.hibernate.Session;
import ru.kamchatgtu.studium.DAO.DAOAbstr;
import ru.kamchatgtu.studium.engine.HibernateUtil;
import ru.kamchatgtu.studium.entity.Log;

import java.sql.SQLException;
import java.util.Collection;

public class LogDAOImpl extends DAOAbstr<Log> {
    @Override
    public Log get(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return (Log) session.createQuery("from Log where idLog = :id").setParameter("id", id).getSingleResult();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    @Override
    public Collection search(Log value) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Log where codeQuery like '%" + value.getCodeQuery() +
                    "%' or typeQuery like '%" + value.getTypeQuery() +
                    "%' or textQuery like '%" + value.getTextQuery() +
                    "%' or textQuery like '%" + value.getTableName() +
                    "%'").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    @Override
    public Collection getAll() throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Log").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }
}
