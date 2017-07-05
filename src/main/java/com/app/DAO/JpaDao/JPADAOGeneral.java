package com.app.DAO.JpaDao;

import com.app.DAO.DAO;
import com.app.Utils.EMFactory;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by User on 05.07.2017.
 */
public abstract class JPADAOGeneral<K extends Serializable,T> implements DAO<K, T> {

    @Override
    public void create(T entity) {
        EntityManager em = EMFactory.getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }


    @Override
    public void update(T entity) {
        EntityManager em = EMFactory.getEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public void delete(T entity) {
        EntityManager em = EMFactory.getEntityManager();
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }
}
