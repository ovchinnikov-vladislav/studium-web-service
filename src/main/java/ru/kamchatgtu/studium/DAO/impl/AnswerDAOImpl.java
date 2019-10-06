package ru.kamchatgtu.studium.DAO.impl;

import org.hibernate.Session;
import ru.kamchatgtu.studium.DAO.DAOAbstr;
import ru.kamchatgtu.studium.engine.HibernateUtil;
import ru.kamchatgtu.studium.entity.Answer;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Объект класса {@code AnswerDAOImpl} реализует запросы к ответам по вопросам:
 *  <br>1. Получение по id ответа
 *  <br>2. Получение всех ответов
 *  <br>3. Поиск конкретного ответа
 *  <br>4. Поиск ответов по id вопроса
 *  <br>5. Получение только правильных ответов по id вопроса
 * @author Овчинников В.А.
 */
public class AnswerDAOImpl extends DAOAbstr<Answer> {

    /**
     * Метод реализует получение конкретного ответа по id
     * @param id является идентификатором ответа
     * @return возращает конкретный ответ из БД
     * @throws SQLException
     */
    @Override
    public Answer get(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.load(Answer.class, id);
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод реализует получение всех ответов из БД
     * @return возращает коллекцию ответов из БД
     * @throws SQLException
     */
    @Override
    public Collection getAll() throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Answer").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод реализует поиск по ответам
     * @param value является объектом ответа
     * @return возращает коллекцию ответов из БД
     * @throws SQLException
     */
    @Override
    public Collection search(Answer value) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            return session.createQuery("from Answer where answerText like '%"+value.getAnswerText()+"%'").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод реализует поиск ответов по id вопроса
     * @param id является id вопроса
     * @return возращает коллекцию ответов из БД
     * @throws SQLException
     */
    public Collection getByQuestion(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Answer where question.idQuestion = :id").setParameter("id", id).list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод реализует получение только правильных ответов на конкретный вопрос по id вопроса
     * @param id является id вопроса
     * @return возращает коллекцию ответов из БД
     * @throws SQLException
     */
    public Collection getRightAnswerByQuestion(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createSQLQuery("select * from Answer where id_question = :idQuestion and correct = 1").setParameter("idQuestion", id).list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }
}
