package ru.kamchatgtu.studium.DAO.impl;

import org.hibernate.Session;
import ru.kamchatgtu.studium.DAO.DAOAbstr;
import ru.kamchatgtu.studium.engine.HibernateUtil;
import ru.kamchatgtu.studium.entity.*;
import java.sql.SQLException;
import java.util.*;

/**
 * Объект класса {@code SubjectDAOImpl} реализует запросы к дисциплинам:
 * <br>1. Получение дисциплины по id
 * <br>2. Поиск дисциплин
 * <br>3. Получение всех дисциплин
 * <br>4. Получение дисциплин с тестами по id пользователя
 * <br>5. Получение дисциплин по id направления подготовки
 * @author Овчинников В.А.
 */
public class SubjectDAOImpl extends DAOAbstr<Subject> {

    /**
     * Метод получения дисциплины по id
     * @param id идентификатор дисциплины
     * @return возращает конкретную дисциплину
     * @throws SQLException
     */
    @Override
    public Subject get(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.load(Subject.class, id);
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод поиска дисциплины
     * @param value объект дисциплины
     * @return возращает коллекцию дисциплин
     * @throws SQLException
     */
    @Override
    public Collection search(Subject value) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Subject where subjectName like '%"+value.getSubjectName()+"%'").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения всех дисциплин
     * @return возращает коллекцию дисциплин
     * @throws SQLException
     */
    @Override
    public Collection getAll() throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Subject").list();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения дисциплин с тестами по id пользователя
     * @param id идентификатор пользователя
     * @return возращает коллекцию дисциплин с тестами
     * @throws SQLException
     */
    public Collection getSubjectsWithTestsByUser(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            List<Test> tests = (session.createQuery("from Test where user.idUser = :id").setParameter("id", id)).list();
            Set<Subject> subjects = new LinkedHashSet<>();
            for (Test test : tests) {
                subjects.add(test.getSubject());
            }
            return subjects;
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения дисциплин по id пользователя
     * @param id идентификатор пользователя
     * @return возвращает коллекцию дисциплин
     */
    public Collection getByUser(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return ((User) session.createQuery("from User where idUser = :id").setParameter("id", id).getSingleResult()).getSubjects();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }

    /**
     * Метод получения дисциплин по id направления подготовки
     * @param id идентификатор направления подготовки
     * @return возвращает коллекцию дисциплин
     * @throws SQLException
     */
    public Collection getByDirection(Integer id) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return ((Direction) session.createQuery("from Direction where idDirection = :id").setParameter("id", id).getSingleResult()).getSubjects();
        } catch (Exception exc) {
            throw new SQLException(exc);
        }
    }
}
