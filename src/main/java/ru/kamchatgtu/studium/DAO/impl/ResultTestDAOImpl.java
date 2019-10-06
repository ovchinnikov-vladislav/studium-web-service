package ru.kamchatgtu.studium.DAO.impl;

import org.hibernate.Session;
import ru.kamchatgtu.studium.DAO.DAOAbstr;
import ru.kamchatgtu.studium.engine.HibernateUtil;
import ru.kamchatgtu.studium.entity.ResultTest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Объект класса {@code ResultTestDAOImpl} реализует запросы к результатам по тестам:
 * <br>1. Получение результата по тесту по id
 * <br>2. Поиск результатов по тестам
 * <br>3. Получение всех результатов по тестам
 * <br>4. Получение результатов по тестам по id пользователя, создавшего тесты
 * <br>5. Получение результатов по тестам по id пользователя, прошедшего тесты
 * <br>6. Поиск результатов по тестам по id пользователя, создавшего тесты
 * <br>7. Поиск результатов по тестам по id пользователя, прошедшего тесты
 * @author Овчинников В.А.
 */
public class ResultTestDAOImpl extends DAOAbstr<ResultTest> {

    /**
     * Метод получения результата по тесту по id
     * @param id идентификатор результата по тесту
     * @return возращает конкретный результат по тесту
     * @throws SQLException
     */
    @Override
    public ResultTest get(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.load(ResultTest.class, id);
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод поиска результатов по тестам
     * @param value объект результата по тесту
     * @return возращает коллекцию результатов по тестам
     * @throws SQLException
     */
    @Override
    public Collection search(ResultTest value) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from ResultTest where test.testName like '%"+value.getTest().getTestName()+"%'" +
                    " or user.fio like '%"+value.getUser().getFio()+"%'" +
                    " or user.login like '%"+value.getUser().getLogin()+"%'").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения всех результатов по тестам
     * @return возращает коллекцию результатов по тестам
     * @throws SQLException
     */
    @Override
    public Collection getAll() throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from ResultTest").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения результатов по тестам по id пользователя, прошедшего тесты
     * @param id идентификатор пользователя
     * @return возращает коллекцию результатов по тестам
     * @throws SQLException
     */
    public Collection getByUser(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from ResultTest where user.idUser = :user order by dateEnd desc").setParameter("user", id).list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения результатов по тестам по id пользователям, создавшего тесты
     * @param id идентификатор пользователя
     * @return возращает коллекцию результатов по тестам
     * @throws SQLException
     */
    public Collection getByUserTests(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List list = new ArrayList();
            List tests = session.createQuery("from Test where user.idUser = :user").setParameter("user", id).list();
            for (Object test: tests) {
                list.addAll(session.createQuery("from ResultTest where test = :test order by dateEnd desc").setParameter("test", test).list());
            }
            return list;
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод поиска результатов по тестам по id пользователя, создавшего тесты
     * @param value объект результата по тесту
     * @return возращает коллекцию результатов по тестам
     * @throws SQLException
     */
    public Collection searchByUserTests(ResultTest value) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List list = new ArrayList();
            List tests = session.createQuery("from Test where user = :user").setParameter("user", value.getTest().getUser()).list();
            for (Object test: tests) {
                if (value.getMark() == 0) {
                    list.addAll(session.createQuery("from ResultTest where test = :test and " +
                            "(user.fio like '%" + value.getUser().getFio() + "%' or " +
                            "test.testName like '%" + value.getTest().getTestName() + "%'" +
                            ") order by dateEnd desc").setParameter("test", test).list());
                } else {
                    list.addAll(session.createQuery("from ResultTest where test = :test and " +
                            "(user.fio like '%" + value.getUser().getFio() + "%' or " +
                            "test.testName like '%" + value.getTest().getTestName() + "%' or " +
                            "mark = " + value.getMark() + ") order by dateEnd desc").setParameter("test", test).list());
                }
            }
            return list;
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод поиска результатов по тестам по id пользователя, прошедшего тесты
     * @param value объект результата по тестам
     * @return возращает коллекцию результатов по тестам
     * @throws SQLException
     */
    public Collection searchByUser(ResultTest value) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from ResultTest where user = :user and " +
                    "(test.testName like '%" + value.getTest().getTestName() + "%') order by dateEnd desc").setParameter("user", value.getUser()).list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }
}
