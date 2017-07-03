package com.app.DAO.HibernateDao.HibernateDaoImpl;

import com.app.DAO.HibernateDao.HibernateDAOGeneral;
import com.app.DAO.HibernateDao.HibernateDAOProject;
import com.app.HibernateEntities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * Created by User on 27.06.2017.
 */
public class HibernateDAOProjectImpl extends HibernateDAOGeneral<Integer, Project> implements HibernateDAOProject{
    @Override
    public Optional<Project> read(Integer key) {
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Project entity = em.find(Project.class, key);
        em.getTransaction().commit();
        return Optional.ofNullable(entity);
    }

    @Override
    public void delete(Project entity) {
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.getReference(Project.class, entity.getId()));
        em.getTransaction().commit();
    }

    @Override
    public List<Project> getAll() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Project> typedQuery = em.createNamedQuery("Project.getAll", Project.class);
        List<Project> projects = typedQuery.getResultList();
        em.getTransaction().commit();
        return projects;
    }
}
