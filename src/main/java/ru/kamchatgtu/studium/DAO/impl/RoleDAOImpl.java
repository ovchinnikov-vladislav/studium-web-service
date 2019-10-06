package ru.kamchatgtu.studium.DAO.impl;

import org.hibernate.Session;
import ru.kamchatgtu.studium.DAO.DAOAbstr;
import ru.kamchatgtu.studium.engine.HibernateUtil;
import ru.kamchatgtu.studium.entity.Role;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Объект класса {@code RoleDAOImpl} реализует запросы к ролям пользователей:
 * <br>1. Получение роли по id
 * <br>2. Поиск роли
 * <br>3. Получение всех ролей
 * @author Овчинников В.А.
 */
public class RoleDAOImpl extends DAOAbstr<Role> {
    /**
     * Метод получения роли пользователя по id
     * @param id идентификатор роли
     * @return возращает конкретную роль
     * @throws SQLException
     */
    @Override
    public Role get(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.load(Role.class, id);
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод поиска ролей пользователей
     * @param value объект роли пользователя
     * @return возращает коллекцию ролей пользователей
     * @throws SQLException
     */
    @Override
    public Collection search(Role value) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Role where " +
                    "roleName like '%" + value.getRoleName() + "%'").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения всех ролей пользователей
     * @return возращает коллекцию всех ролей пользователей
     * @throws SQLException
     */
    @Override
    public Collection getAll() throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Role").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }
}
