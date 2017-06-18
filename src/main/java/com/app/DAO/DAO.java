package com.app.DAO;

import java.util.List;
import java.util.Optional;

/**
 * Created by User on 04.06.2017.
 */
public interface  DAO<T> {

    void create(T entity);

    Optional<T> read(int id);

    /**
     *
     * @param entity
     * @return old entity
     */
    Optional<T> update(T entity);

    boolean delete(int id);

    List<T> getAll();
}
