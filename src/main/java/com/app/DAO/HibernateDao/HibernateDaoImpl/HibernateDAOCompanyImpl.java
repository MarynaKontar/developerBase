package com.app.DAO.HibernateDao.HibernateDaoImpl;

import com.app.DAO.HibernateDao.HibernateDAOCompany;
import com.app.DAO.HibernateDao.HibernateDAOGeneral;
import com.app.HibernateEntities.Company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

/**
 * Created by User on 27.06.2017.
 */
public class HibernateDAOCompanyImpl extends HibernateDAOGeneral<Integer, Company> implements HibernateDAOCompany{
//    @Override
//    public void create(Company entity) {
//        EntityManagerFactory factory= Persistence.createEntityManagerFactory("unit1");
//        EntityManager em = factory.createEntityManager();
//        em.getTransaction().begin();
//        em.persist(entity);
//        em.getTransaction().commit();
//    }

    @Override
    public Optional<Company> read(Integer key) {
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Company entity = em.find(Company.class, key);
        em.getTransaction().commit();
        return Optional.ofNullable(entity);
    }

    @Override
    public void delete(Company entity) {
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.getReference(Company.class, entity.getId()));
        em.getTransaction().commit();
    }

    @Override
    public List<Company> getAll() {
        return null;
    }

}
