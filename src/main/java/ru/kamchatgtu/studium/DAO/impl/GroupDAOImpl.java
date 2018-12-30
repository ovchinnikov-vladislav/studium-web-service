package ru.kamchatgtu.studium.DAO.impl;

import ru.kamchatgtu.studium.entity.Group;

import java.sql.SQLException;
import java.util.Collection;

import ru.kamchatgtu.studium.engine.HibernateUtil;

import org.hibernate.Session;
import ru.kamchatgtu.studium.entity.Position;

public class GroupDAOImpl extends DAOImpl<Group> {
    @Override
    public Group get(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.load(Group.class, id);
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public Collection search(Group value) throws SQLException {
        // TODO: поиск по группам
        return null;
    }

    @Override
    public Collection getAll() throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Collection collection = session.createQuery("from Group").list();
            if (collection != null && collection.size() > 0)
                return collection;
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new SQLException();
        }
        return null;
    }

    public Collection getGroupsByPosition(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Collection collection = session.createQuery("select distinct p.groups from Position p where p.idPosition = :position").setParameter("position", id).list();
            if (collection != null && collection.size() > 0) {
                return collection;
            }
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new SQLException();
        }
        return null;
    }
}
