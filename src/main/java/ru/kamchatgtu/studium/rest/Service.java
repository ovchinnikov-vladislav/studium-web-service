package ru.kamchatgtu.studium.rest;

import ru.kamchatgtu.studium.DAO.DAO;
import java.util.Collection;

/**
 * Класс {@code Service} реализует основные методы доступа к сервису:
 * <br>1. Получение объекта по id
 * <br>2. Получение всех объектов
 * <br>3. Добавление объекта
 * <br>4. Удаление объекта
 * <br>5. Обновление объекта
 * @author Овчинников В.А.
 * @param <T> тип объекта
 */
public class Service<T> implements AbstractService<T> {

    private DAO<T> dao;

    public Service(DAO<T> dao) {
        this.dao = dao;
    }

    /**
     * Метод получения объекта по id
     * @param id идентификатор объекта
     * @return возвращает объект
     */
    public T get(Integer id) {
        try {
            return getDao().get(id);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    /**
     * Метод получения всех объектов
     * @return возращает коллекцию объектов
     */
    public Collection getAll() {
        try {
            return getDao().getAll();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    /**
     * Метод добавления объекта
     * @param request объект
     * @return возращает объект
     */
    public T add(T request) {
        try {
            boolean isExecute = dao.add(request);
            if (isExecute)
                return request;
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    /**
     * Метод удаления объекта
     * @param request объект
     * @return возвращает объект
     */
    public T remove(T request) {
        try {
            boolean isExecute = dao.remove(request);
            if (isExecute)
                return request;
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    /**
     * Метод обновления объекта
     * @param request объект
     * @return возвращает объект
     */
    public T update(T request) {
        try {
            boolean isExecute = dao.update(request);
            if (isExecute)
                return request;
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    /**
     * Метод поиска объектов
     * @param request объект
     * @return возвращает коллекцию объектов
     */
    public Collection search(T request) {
        try {
            return dao.search(request);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    /**
     * Метод получения DAO к БД
     * @return возвращет DAO к БД
     */
    public DAO<T> getDao() {
        return dao;
    }
}
