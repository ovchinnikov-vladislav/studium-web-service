package ru.kamchatgtu.studium.DAO;

import java.sql.SQLException;
import java.util.Collection;

public interface DAO<T> {
    boolean add(T t) throws SQLException;
    boolean remove(T t) throws SQLException;
    boolean update(T t) throws SQLException;
    T get(Integer id) throws SQLException;
    Collection search(T value) throws SQLException;
    Collection getAll() throws SQLException;
}
