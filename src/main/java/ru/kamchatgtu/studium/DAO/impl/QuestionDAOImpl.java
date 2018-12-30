package ru.kamchatgtu.studium.DAO.impl;

import org.hibernate.Session;
import ru.kamchatgtu.studium.engine.HibernateUtil;
import ru.kamchatgtu.studium.entity.Question;
import ru.kamchatgtu.studium.entity.Theme;

import java.sql.SQLException;
import java.util.Collection;

public class QuestionDAOImpl extends DAOImpl<Question> {

    @Override
    public Question get(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.load(Question.class, id);
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public Collection search(Question value) throws SQLException {
        // TODO: поиск по вопросам
        return null;
    }

    @Override
    public Collection getAll() throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Question").list();
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new SQLException();
        }
    }

    public Collection getThemes() throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Theme").list();
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new SQLException();
        }
    }

    public Collection searchByTheme(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Question where theme.idTheme = :theme").setParameter("theme", id).list();
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new SQLException();
        }
    }
}
