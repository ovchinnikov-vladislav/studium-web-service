package ru.kamchatgtu.studium.DAO.impl;

import ru.kamchatgtu.studium.DAO.DAOAbstr;
import ru.kamchatgtu.studium.engine.HibernateUtil;
import ru.kamchatgtu.studium.entity.User;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import org.hibernate.Session;

/**
 * Объект класса {@code UserDAOImpl} реализует запросы к пользователям:
 * <br>1. Получение пользователя по id
 * <br>2. Поиск пользователя
 * <br>3. Получение всех пользователей
 * <br>4. Метод получения пользователя по login или email
 * <br>5. Метод получения пользователя только по login
 * <br>6. Метод получения пользователя только по email
 * @author Овчинников В.А.
 */
public class UserDAOImpl extends DAOAbstr<User> {

    /**
     * Метод получения пользователя по id
     * @param id идентификатор пользователя
     * @return возращает конретного пользователя
     * @throws SQLException
     */
    @Override
    public User get(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.load(User.class, id);
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод поиска пользователя
     * @param value объект пользователя
     * @return возращает коллекцию пользователей
     * @throws SQLException
     */
    @Override
    public Collection search(User value) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            return session.createQuery("from User where " +
                     "login like '%"+value.getLogin()+"%' " +
                    "or email like '%"+value.getEmail()+"%' " +
                    "or fio like '%"+value.getFio()+"%' " +
                    "or direction.idDirection = " + value.getDirection().getIdDirection() + " " +
                    "or group.idGroup = " + value.getGroup().getIdGroup() + " " +
                    "or role.idRole = " + value.getRole().getIdRole() + " " +
                    "or phone like '%"+value.getPhone()+"%'").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения всех пользователей
     * @return возращает коллекцию пользователей
     * @throws SQLException
     */
    @Override
    public Collection getAll() throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from User").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения пользователя по login или email
     * @param login login или email пользователя
     * @return возращает конкретного пользователя
     * @throws SQLException
     */
    public User signIn(String login) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Collection query = session.createQuery("from User where (login = :login or email = :login)").
                    setParameter("login", login).
                    list();
            if (query.size() == 1)
                return (User) ((List) query).get(0);
            return null;
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения пользователя по login
     * @param login логин пользователя
     * @return возращает конкретного пользователя
     * @throws SQLException
     */
    public User getByLogin(String login) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Collection query = session.createQuery("from User where login = :login").setParameter("login", login).list();
            if (query.size() > 0)
                return (User) ((List) query).get(0);
            return null;
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения пользователя по email
     * @param email e-mail пользователя
     * @return возращает конкретного пользователя
     * @throws SQLException
     */
    public User getByEmail(String email) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Collection query = session.createQuery("from User where email = :email").setParameter("email", email).list();
            if (query.size() > 0)
                return (User) ((List) query).get(0);
            return null;
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения списка студентов
     * @return возращает спиоск студентов
     * @throws SQLException
     */
    public Collection getStudents() throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from User where role.idRole = 3").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения списка преподавателей
     * @return возращает список преподавателей
     * @throws SQLException
     */
    public Collection getTeachers() throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from User where role.idRole = 2").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения списка администраторов
     * @return возращает список администраторов
     * @throws SQLException
     */
    public Collection getAdministrators() throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from User where role.idRole = 1").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения списка пользователей по id группы
     * @return возращает список пользователей по id группы
     * @throws SQLException
     */
    public Collection getByGroup(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from User where group.idGroup = :id").setParameter("id", id).list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }
}
