package ru.kamchatgtu.studium.DAO.impl;

import org.hibernate.Session;
import ru.kamchatgtu.studium.engine.HibernateUtil;
import ru.kamchatgtu.studium.entity.Question;
import ru.kamchatgtu.studium.entity.Theme;

import java.sql.SQLException;
import java.util.Collection;

public class ThemeDAOImpl extends DAOImpl<Theme> {
    @Override
    public Theme get(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.load(Theme.class, id);
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public Collection search(Theme value) throws SQLException {
        return null;
    }

    @Override
    public Collection getAll() throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Theme").list();
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new SQLException();
        }
    }
}
