package ru.kamchatgtu.studium.DAO.impl;

import org.hibernate.Session;
import ru.kamchatgtu.studium.DAO.DAOAbstr;
import ru.kamchatgtu.studium.engine.HibernateUtil;
import ru.kamchatgtu.studium.entity.Question;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Объект класса {@code QuestionDAOImpl} реализует запросы к вопросам:
 * <br>1. Получение вопроса по id
 * <br>2. Поиск вопросов
 * <br>3. Получение всех вопросов
 * <br>4. Получение вопросов по теме
 * @author Овчинников В.А.
 */
public class QuestionDAOImpl extends DAOAbstr<Question> {

    /**
     * Метод получения вопроса по id
     * @param id идентификатор вопроса
     * @return возращает конкретный вопрос
     * @throws SQLException
     */
    @Override
    public Question get(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.load(Question.class, id);
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод поиска вопросов
     * @param value объект вопроса
     * @return возращает коллекцию вопросов
     * @throws SQLException
     */
    @Override
    public Collection search(Question value) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Question where questionText like '%"+value.getQuestionText()+"%'" +
                    " or theme.themeText like '%"+value.getTheme().getThemeText()+"%'").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения всех вопросов
     * @return возращает коллекцию вопросов
     * @throws SQLException
     */
    @Override
    public Collection getAll() throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Question").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения вопросов по id темы
     * @param id идентификатор темы
     * @return возращает коллекцию вопросов
     * @throws SQLException
     */
    public Collection getByTheme(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Question where theme.idTheme = :theme").setParameter("theme", id).list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения правильных ответов по id вопроса
     * @param id идентификатор вопроса
     * @return возвращает коллекцию правильных ответов
     * @throws SQLException
     */
    public Collection getRightAnswerByQuestion(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Answer where question.id = :id and correct = true").setParameter("id" , id).list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }
}
