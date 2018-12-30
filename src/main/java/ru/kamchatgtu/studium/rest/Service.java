package ru.kamchatgtu.studium.rest;

import ru.kamchatgtu.studium.DAO.DAO;
import ru.kamchatgtu.studium.DAO.Factory;

import java.util.ArrayList;
import java.util.Collection;

public class Service<T> implements AbstractService<T> {

    private DAO<T> dao;

    public Service(DAO<T> dao) {
        this.dao = dao;
    }

    public T get(Integer id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return getDao().get(id);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    public Collection getAll() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return getDao().getAll();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    public T add(T request) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            boolean isExecute = dao.add(request);
            if (isExecute)
                return request;
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    public T remove(T request) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            boolean isExecute = dao.remove(request);
            if (isExecute)
                return request;
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    public T update(T request) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            boolean isExecute = dao.update(request);
            if (isExecute)
                return request;
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    public DAO<T> getDao() {
        return dao;
    }
}
