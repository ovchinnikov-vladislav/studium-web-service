package ru.kamchatgtu.studium.DAO;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Интерфейс {@code DAO} объявляет следующие методы:
 * <br>1. Добавление объекта в БД
 * <br>2. Удаление объекта из БД
 * <br>3. Обновление объекта в БД
 * <br>4. Получение объекта из БД по id объекта
 * <br>5. Поиск объекта в БД
 * <br>6. Получение всех объектов из БД
 * @author Овчинников В.А.
 * @param <T> тип объекта, хранимого в БД
 */
public interface DAO<T> {
    /**
     * Абстрактный метод добавления объекта в БД
     * @param t объект, добавляемый в БД
     * @return возращает логическое значение true или false в случае успеха
     * @throws SQLException
     */
    boolean add(T t) throws SQLException;

    /**
     * Абстрактный метод удаление объекта из БД
     * @param t объект, удаляемый из БД
     * @return возращает логическое значение true или false в случае успеха
     * @throws SQLException
     */
    boolean remove(T t) throws SQLException;

    /**
     * Абстрактный метод обновления объекта в БД
     * @param t объект, обновляемый в БД
     * @return возращает логическое значение true или false в случае успеха
     * @throws SQLException
     */
    boolean update(T t) throws SQLException;

    /**
     * Абстрактный метод получения объекта из БД
     * @param id идентификатор объекта
     * @return возращает объект, полученный из БД
     * @throws SQLException
     */
    T get(Integer id) throws SQLException;

    /**
     * Абстрактный метод поиска объекта в БД
     * @param value объект
     * @return возращает коллекцию объектов
     * @throws SQLException
     */
    Collection search(T value) throws SQLException;

    /**
     * Абстрактный метод получения всех объектов из БД
     * @return возращает коллекцию объектов
     * @throws SQLException
     */
    Collection getAll() throws SQLException;
}
