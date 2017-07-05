package com.app.DAO.JpaDao.JpaDaoImpl;

import com.app.DAO.JpaDao.JPADAOGeneral;
import com.app.DAO.JpaDao.JpaDAOCompany;
import com.app.HibernateEntities.Company;
import com.app.Utils.EMFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * Created by User on 27.06.2017.
 */
public class JPADAOCompanyImpl extends JPADAOGeneral<Integer, Company> implements JpaDAOCompany {
//    @Override
//    public void create(Company entity) {
//        EntityManager em = EMFactory.getEntityManager();
//        em.getTransaction().begin();
//        em.persist(entity);
//        em.getTransaction().commit();
//    }

    @Override
    public Optional<Company> read(Integer key) {
        EntityManager em = EMFactory.getEntityManager();
        em.getTransaction().begin();
        Company entity = em.find(Company.class, key);
        em.getTransaction().commit();
        return Optional.ofNullable(entity);
    }

    @Override
    public void delete(Company entity) {
        EntityManager em = EMFactory.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.getReference(Company.class, entity.getId()));
        em.getTransaction().commit();
    }

    @Override
    public List<Company> getAll() {
        EntityManager em = EMFactory.getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Company> typedQuery = em.createNamedQuery("Company.getAll", Company.class);
        List<Company> companies = typedQuery.getResultList();
        em.getTransaction().commit();
        return companies;
    }

}
