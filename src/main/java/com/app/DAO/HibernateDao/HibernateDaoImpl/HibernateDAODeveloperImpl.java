package com.app.DAO.HibernateDao.HibernateDaoImpl;

import com.app.DAO.HibernateDao.HibernateDAODeveloper;
import com.app.DAO.HibernateDao.HibernateDAOGeneral;
import com.app.HibernateEntities.Developer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by User on 22.06.2017.
 */
public class HibernateDAODeveloperImpl extends HibernateDAOGeneral<Integer, Developer> implements HibernateDAODeveloper {

//    @Override
//    public void create(Developer entity) {
//        EntityManagerFactory factory= Persistence.createEntityManagerFactory("unit1");
//        EntityManager em = factory.createEntityManager();
//        em.getTransaction().begin();
//        em.persist(entity);
//        em.getTransaction().commit();
//    }

    @Override
    public Optional<Developer> read(Integer key) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Developer developer = em.find(Developer.class, key);
        em.getTransaction().commit();
        return Optional.ofNullable(developer);
    }

    @Override
    public void delete(Developer entity) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.getReference(Developer.class, entity.getId()));
        em.getTransaction().commit();
    }

    @Override
    public List<Developer> getAll() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Developer> typedQuery = em.createNamedQuery("Developer.getAll", Developer.class);
        List<Developer> developers = typedQuery.getResultList();
        em.getTransaction().commit();
    return developers;
    }
}
