package ru.kamchatgtu.studium.DAO.impl;

import ru.kamchatgtu.studium.DAO.DAOAbstr;
import ru.kamchatgtu.studium.engine.HibernateUtil;
import ru.kamchatgtu.studium.entity.Direction;
import java.sql.SQLException;
import java.util.Collection;
import org.hibernate.Session;

/**
 * Объект класса {@code DirectionDAOImpl} реализует запросы к направлениям подготовки:
 * <br>1. Получение направления подготовки по id
 * <br>2. Поиск направления подготовки
 * <br>3. Получение всех направлений подготовки
 * <br>4. Получение направлений подготовки по id факультета
 * @author Овчинников В.А.
 */
public class DirectionDAOImpl extends DAOAbstr<Direction> {

    /**
     * Метод получения направления подготовки по id
     * @param id является идентификатором направление подготовки
     * @return возращает конкретное направление подготовки
     * @throws SQLException
     */
    @Override
    public Direction get(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.load(Direction.class, id);
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод поиска направления подготовки
     * @param value является направлением подготовки
     * @return возращает коллекцию направлений подготовки
     * @throws SQLException
     */
    @Override
    public Collection search(Direction value) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Direction where " +
                    "directionName like '%" + value.getDirectionName() + "%'").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения всех направлений подготовки
     * @return возращает коллекцию направлений подготовки
     * @throws SQLException
     */
    @Override
    public Collection getAll() throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Direction").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения направлений подготовки по id факультета
     * @param id является идентификатором факультета
     * @return возращает коллекцию направлений подготовки
     * @throws SQLException
     */
    public Collection getByFaculty(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Collection collection = session.createQuery("select distinct f.directions from Faculty f where f.idFaculty = :faculty").setParameter("faculty", id).list();
            if (collection != null && collection.size() > 0) {
                return collection;
            }
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
        return null;
    }
}
