package ru.kamchatgtu.studium.DAO.impl;

import org.springframework.stereotype.Repository;
import ru.kamchatgtu.studium.engine.HibernateUtil;
import ru.kamchatgtu.studium.entity.User;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

@Repository
public class UserDAOImpl extends DAOImpl<User> {
    @Override
    public User get(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.load(User.class, id);
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public Collection search(User value) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Collection query = session.createQuery("from User where login like '%"+ value.getLogin() +"%' or " +
                    "email like '%"+ value.getEmail() +"%' or fio like '%"+ value.getFio() +"%' or group.nameGroup like '%"+ value.getGroup().getNameGroup() +"%' or " +
                    "position.position like '%"+ value.getPosition().getPosition() +"%' or phone like '%"+ value.getPhone() +"%'").list();
            return query;
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public Collection getAll() throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from User").list();
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new SQLException();
        }
    }

    public User login(String login) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Collection query = session.createQuery("from User where (login = :login or email = :login)").
                    setParameter("login", login).
                    list();
            if (query.size() == 1)
                return (User) ((List) query).get(0);
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new SQLException();
        }
        return null;
    }

    public User searchByLogin(String login) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Collection query = session.createQuery("from User where login = '"+login+"'").list();
            if (query.size() > 0)
                return (User) ((List) query).get(0);
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new SQLException();
        }
        return null;
    }

    public User searchByEmail(String email) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Collection query = session.createQuery("from User where email = '" +email+ "'").list();
            if (query.size() > 0)
                return (User) ((List) query).get(0);
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new SQLException();
        }
        return null;
    }
}
