package com.app.DAO;

import java.util.List;

/**
 * Created by User on 04.06.2017.
 */
public interface  DAO<T> {

    void create(T entity);

    T read(long id);

    T update(T entity);

    boolean delete(long id);

    List<T> getAll();
}
