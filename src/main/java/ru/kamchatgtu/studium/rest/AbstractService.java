package ru.kamchatgtu.studium.rest;

import java.util.Collection;

public interface AbstractService<T> {
    T add(T t);
    T update(T t);
    T remove(T t);
    T get(Integer id);
    Collection getAll();
}
