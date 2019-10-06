package ru.kamchatgtu.studium.DAO.impl;

import ru.kamchatgtu.studium.DAO.DAOAbstr;
import ru.kamchatgtu.studium.engine.HibernateUtil;
import ru.kamchatgtu.studium.entity.Faculty;
import java.sql.SQLException;
import java.util.Collection;
import org.hibernate.Session;

/**
 * Объект класса {@code FacultyDAOImpl} реализует запросы к факультетам:
 * <br>1. Получение конкретного факультета по id
 * <br>2. Поиск факультетов
 * <br>3. Получение всех факультетов
 * @author Овчинников В.А.
 */
public class FacultyDAOImpl extends DAOAbstr<Faculty> {

    /**
     * Метод получения факультета по id
     * @param id является идентификатором факультета
     * @return возращает конкретный факультет
     * @throws SQLException
     */
    @Override
    public Faculty get(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.load(Faculty.class, id);
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод поиска факультетов
     * @param value является объектом факультета
     * @return возращает коллекцию факультетов
     * @throws SQLException
     */
    @Override
    public Collection search(Faculty value) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Faculty where facultyName like '%"+value.getFacultyName()+"%'").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения всех факультетов
     * @return возращает коллекцию факультетов
     * @throws SQLException
     */
    @Override
    public Collection getAll() throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Faculty").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }
}
