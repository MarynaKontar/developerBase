package com.app.DAO;

/**
 * Created by User on 04.06.2017.
 */
public interface  DAO<T> {

    void create(T entity);

    T read(int id);

    T update(int id, T entity);

    void delete(int id);
}
