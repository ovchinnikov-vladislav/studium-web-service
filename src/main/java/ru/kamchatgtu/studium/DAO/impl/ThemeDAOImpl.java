package ru.kamchatgtu.studium.DAO.impl;

import org.hibernate.Session;
import ru.kamchatgtu.studium.DAO.DAOAbstr;
import ru.kamchatgtu.studium.engine.HibernateUtil;
import ru.kamchatgtu.studium.entity.Theme;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Объект класса {@code ThemeDAOImpl} реализует запросы к темам вопросов:
 * <br>1. Получение темы по id
 * <br>2. Поиск темы
 * <br>3. Получение всех тем
 * @author Овчинников В.А.
 */
public class ThemeDAOImpl extends DAOAbstr<Theme> {

    /**
     * Метод получения темы по id
     * @param id идентификатор темы
     * @return возращает конкретную тему
     * @throws SQLException
     */
    @Override
    public Theme get(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.load(Theme.class, id);
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод поиска темы
     * @param value объект темы
     * @return возращает коллекцию тем
     * @throws SQLException
     */
    @Override
    public Collection search(Theme value) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Theme where themeText like '%" + value.getThemeText()+"%'").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получени всех тем
     * @return возращает коллекцию тем
     * @throws SQLException
     */
    @Override
    public Collection getAll() throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Theme").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }
}
