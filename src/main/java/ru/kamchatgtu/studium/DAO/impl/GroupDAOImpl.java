package ru.kamchatgtu.studium.DAO.impl;

import ru.kamchatgtu.studium.DAO.DAOAbstr;
import ru.kamchatgtu.studium.entity.Group;
import java.sql.SQLException;
import java.util.Collection;
import ru.kamchatgtu.studium.engine.HibernateUtil;
import org.hibernate.Session;

/**
 * Объект класса {@code GroupDAOImpl} реализует запросы к группам:
 * <br>1. Получение группы по id
 * <br>2. Поиск групп
 * <br>3. Получение всех групп
 * <br>4. Получение групп по id роли
 * <br>5. Получение групп по id направления подготовки
 * @author Овчинников В.А.
 */
public class GroupDAOImpl extends DAOAbstr<Group> {

    /**
     * Метод получения группы по id
     * @param id идентификатор группы
     * @return возращает конкретную группу
     * @throws SQLException
     */
    @Override
    public Group get(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.load(Group.class, id);
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод поиска групп
     * @param value является объектом группы
     * @return возращает коллекцию групп
     * @throws SQLException
     */
    @Override
    public Collection search(Group value) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Group where " +
                    "groupName like '%" + value.getGroupName() + "%'").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения всех групп
     * @return возращает коллекцию групп
     * @throws SQLException
     */
    @Override
    public Collection getAll() throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Collection collection = session.createQuery("from Group").list();
            if (collection != null && collection.size() > 0)
                return collection;
            return null;
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения групп по id роли
     * @param id идентификатор роли
     * @return возращает коллекцию групп
     * @throws SQLException
     */
    public Collection getGroupsByRole(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Collection collection = session.createQuery("select distinct r.groups from Role r where r.idRole = :role").setParameter("role", id).list();
            if (collection != null && collection.size() > 0)
                return collection;
            return null;
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения групп по id направления подготовки
     * @param id идентификатор направления подготовки
     * @return возращает коллекцию групп
     * @throws SQLException
     */
    public Collection getGroupsByDirection(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Collection collection = session.createQuery("select distinct d.groups from Direction d where d.idDirection = :direction").setParameter("direction", id).list();
            if (collection != null && collection.size() > 0)
                return collection;
            return null;
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }
}
