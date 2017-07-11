package com.app.DAO.JpaDao.JpaDaoImpl;

import com.app.DAO.JpaDao.JPADAOGeneral;
import com.app.DAO.JpaDao.JpaDAOProject;
import com.app.HibernateEntities.Project;
import com.app.Utils.EMFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * Created by User on 27.06.2017.
 */
public class JPADAOProjectImpl extends JPADAOGeneral<Integer, Project> implements JpaDAOProject {
    @Override
    public Optional<Project> read(Integer key) {
        EntityManager em = EMFactory.getEntityManager();
        em.getTransaction().begin();
        Project entity = em.getReference(Project.class, key);
        em.getTransaction().commit();
        return Optional.ofNullable(entity);
    }

    @Override
    public void delete(Project entity) {
        EntityManager em = EMFactory.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.getReference(Project.class, entity.getId()));
        em.getTransaction().commit();
    }

    @Override
    public List<Project> getAll() {
        EntityManager em = EMFactory.getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Project> typedQuery = em.createNamedQuery("Project.getAll", Project.class);
        List<Project> projects = typedQuery.getResultList();
        em.getTransaction().commit();
        return projects;
    }
}
