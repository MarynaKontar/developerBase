package com.app.DAO.JpaDao.JpaDaoImpl;

import com.app.DAO.JpaDao.JPADAOGeneral;
import com.app.DAO.JpaDao.JpaDAODeveloper;
import com.app.HibernateEntities.Developer;
import com.app.Utils.EMFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * Created by User on 22.06.2017.
 */
public class JPADAODeveloperImpl extends JPADAOGeneral<Integer, Developer> implements JpaDAODeveloper {

    @Override
    public void create(Developer entity) {
        EntityManager em = EMFactory.getEntityManager();
        em.getTransaction().begin();
        em.merge(entity);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Optional<Developer> read(Integer key) {
        EntityManager em = EMFactory.getEntityManager();
        em.getTransaction().begin();
        Developer developer = em.find(Developer.class, key);
        em.getTransaction().commit();
        return Optional.ofNullable(developer);
    }

    @Override
    public void delete(Developer entity) {
        EntityManager em = EMFactory.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.getReference(Developer.class, entity.getId()));
        em.getTransaction().commit();
    }

    @Override
    public List<Developer> getAll() {
        EntityManager em = EMFactory.getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Developer> typedQuery = em.createNamedQuery("Developer.getAll", Developer.class);
        List<Developer> developers = typedQuery.getResultList();
        em.getTransaction().commit();
    return developers;
    }
}
