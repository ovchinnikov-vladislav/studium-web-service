package ru.kamchatgtu.studium.DAO.impl;

import org.hibernate.Session;
import ru.kamchatgtu.studium.DAO.DAOAbstr;
import ru.kamchatgtu.studium.engine.HibernateUtil;
import ru.kamchatgtu.studium.entity.ResultQuestion;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Объект класса {@code ResultQuestionDAOImpl} реализует запросы к результатам по отдельным ответам на вопросы:
 * <br>1. Получение результата по отдельному ответу на вопрос по id
 * <br>2. Поиск результатов по отдельным ответам на вопросы
 * <br>3. Получение всех результатов по отдельным ответам на вопросы
 * <br>4. Получение результатов по отдельным ответам на вопросы по id результата по тесту
 * <br>5. Получение результатов по отдельным ответам на вопросы по id вопроса и id результата по тесту
 * @author Овчинников В.А.
 */
public class ResultQuestionDAOImpl extends DAOAbstr<ResultQuestion> {

    /**
     * Метод получения результата оп отдельному ответу на вопрос по id
     * @param id идентификатор результата по отдельному ответу на вопрос
     * @return возращает конкретный результат по отдельному ответу на вопрос
     * @throws SQLException
     */
    @Override
    public ResultQuestion get(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.load(ResultQuestion.class, id);
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод поиска результатов по отдельному ответу на вопрос
     * @param value объект результата по отдельному ответу на вопрос
     * @return возращает коллекцию результатов по отдельному ответым на вопросы
     * @throws SQLException
     */
    @Override
    public Collection search(ResultQuestion value) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from ResultQuestion where question.questionText like '%"+value.getQuestion().getQuestionText()+"%'" +
                    " or answer.answerText like '%"+value.getAnswer().getAnswerText()+"%'" +
                    " or resultTest.test.testName like '%"+value.getResultTest().getTest().getTestName()+"%'").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения всех результатов по отдельным ответам на вопросы
     * @return возращает коллекцию результатов по отдельным ответам на вопросы
     * @throws SQLException
     */
    @Override
    public Collection getAll() throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from ResultQuestion").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения всех результатов по отдельным ответам на вопросы по id результата по тесту
     * @param id идентификатор результата по тесту
     * @return возращает коллекцию результатов по отдельным ответам на вопросы
     * @throws SQLException
     */
    public Collection getByResultTest(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from ResultQuestion where resultTest.idResult = :id").setParameter("id", id).list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения результатов по отдельным ответам на вопросы по id вопроса и id результата по тесту
     * @param idQuestion идентификатор вопроса
     * @param idResult идентификатор результата по тесту
     * @return возращает коллекцию результатов по отдельным ответам на вопросы
     * @throws SQLException
     */
    public Collection getByQuestionAndResultTest(Integer idQuestion, Integer idResult) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from ResultQuestion where question.idQuestion = :idQuestion and resultTest.idResult = :idResult")
                    .setParameter("idQuestion", idQuestion).setParameter("idResult", idResult).list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод удаления результатов по отдельным ответам на вопросы по id
     * @param id идентификатор вопроса
     * @return возращает коллекцию результатов по отдельным ответам на вопросы
     * @throws SQLException
     */
    public ResultQuestion removeById(Integer id) throws SQLException {
        try {
            ResultQuestion resultQuestion = get(id);
            remove(resultQuestion);
            return resultQuestion;
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }
}
