package ru.kamchatgtu.studium.DAO.impl;

import org.hibernate.Session;
import ru.kamchatgtu.studium.DAO.DAOAbstr;
import ru.kamchatgtu.studium.DAO.Factory;
import ru.kamchatgtu.studium.engine.HibernateUtil;
import ru.kamchatgtu.studium.entity.Question;
import ru.kamchatgtu.studium.entity.Test;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Объект класса {@code TestDAOImpl} реализует запросы к тестам:
 * <br>1. Получение теста по id
 * <br>2. Поиск тестов
 * <br>3. Получение всех тестов
 * <br>4. Получение тестов по id дисциплины
 * <br>5. Получение тестов по id пользователя
 * <br>6. Получение всех правильных ответов теста по id теста
 * @author Овчинников В.А.
 */
public class TestDAOImpl extends DAOAbstr<Test> {

    /**
     * Метод получения теста по id
     * @param id идентификатор теста
     * @return возращает конкретный тест
     * @throws SQLException
     */
    @Override
    public Test get(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.load(Test.class, id);
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод поиска по тестам
     * @param value объект теста
     * @return возращает коллекцию тестов
     * @throws SQLException
     */
    @Override
    public Collection search(Test value) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Test where testName like '%"+value.getTestName()+"%'" +
                    " or subject.subjectName like '%"+value.getSubject().getSubjectName()+"%'" +
                    " or user.fio like '%"+value.getUser().getFio()+"%'").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получение всех тестов
     * @return возращает коллекцию тестов
     * @throws SQLException
     */
    @Override
    public Collection getAll() throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Test").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения тестов по id дисциплины
     * @param id идентификатор дисциплины
     * @return возращает коллекцию тестов
     * @throws SQLException
     */
    public Collection getBySubject(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Test where subject.idSubject = :id").setParameter("id", id).list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения тестов по id пользователя, создавшего их
     * @param id идентификатор пользователя
     * @return возращает коллекцию тестов
     * @throws SQLException
     */
    public Collection getByUser(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Test where user.idUser = :id").setParameter("id", id).list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения всех правильных ответов по id теста
     * @param id идентификатор теста
     * @return возращает коллекцию ответов
     * @throws SQLException
     */
    public Collection getRightAnswerByTest(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Test test = (Test) session.createQuery("from Test where idTest = :idTest").setParameter("idTest", id).getSingleResult();
            Collection<Question> questions = test.getQuestions();
            Collection answers = null;
            for (Question question : questions) {
                if (answers == null)
                    answers = Factory.getInstance().getAnswerDAO().getRightAnswerByQuestion(question.getIdQuestion());
                else
                    answers.addAll(Factory.getInstance().getAnswerDAO().getRightAnswerByQuestion(question.getIdQuestion()));
            }
            return answers;
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения всех вопросов теста по id теста
     * @param id идентификатор теста
     * @return возращает коллекцию ответов
     * @throws SQLException
     */
    public Collection getQuestionsByTest(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Test test = (Test) session.createQuery("from Test where idTest = :idTest").setParameter("idTest", id).getSingleResult();
            return test.getQuestions();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }
}
