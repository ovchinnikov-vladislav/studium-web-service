package ru.kamchatgtu.studium.DAO.impl;

import org.hibernate.Session;
import ru.kamchatgtu.studium.engine.HibernateUtil;
import ru.kamchatgtu.studium.entity.Answer;
import ru.kamchatgtu.studium.entity.Question;

import java.sql.SQLException;
import java.util.Collection;

public class AnswerDAOImpl extends DAOImpl<Answer> {

    @Override
    public Answer get(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.load(Answer.class, id);
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public Collection getAll() throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Answer").list();
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public Collection search(Answer value) throws SQLException {
        // TODO: поиск по ответам
        return null;
    }

    public Collection searchByQuestion(Integer idQuestion) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Answer where question.idQuestion = :idQuestion").setParameter("idQuestion", idQuestion).list();
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new SQLException();
        }
    }
}
