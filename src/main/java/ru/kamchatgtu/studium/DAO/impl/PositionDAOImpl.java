package ru.kamchatgtu.studium.DAO.impl;

import org.hibernate.Session;
import ru.kamchatgtu.studium.engine.HibernateUtil;
import ru.kamchatgtu.studium.entity.Position;

import java.sql.SQLException;
import java.util.Collection;

public class PositionDAOImpl extends DAOImpl<Position> {
    @Override
    public Position get(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.load(Position.class, id);
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public Collection search(Position value) throws SQLException {
        // TODO: поиск по должностям
        return null;
    }

    @Override
    public Collection getAll() throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Position").list();
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new SQLException();
        }
    }
}
