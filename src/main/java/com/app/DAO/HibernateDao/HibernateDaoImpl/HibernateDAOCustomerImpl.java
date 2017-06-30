package com.app.DAO.HibernateDao.HibernateDaoImpl;


import com.app.DAO.HibernateDao.HibernateDAOCustomer;
import com.app.DAO.HibernateDao.HibernateDAOGeneral;
import com.app.HibernateEntities.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

/**
 * Created by User on 27.06.2017.
 */
public class HibernateDAOCustomerImpl extends HibernateDAOGeneral<Integer, Customer> implements HibernateDAOCustomer{
    @Override
    public Optional<Customer> read(Integer key) {
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Customer entity = em.find(Customer.class, key);
        em.getTransaction().commit();
        return Optional.ofNullable(entity);
    }

    @Override
    public void delete(Customer entity) {
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.getReference(Customer.class, entity.getId()));
        em.getTransaction().commit();
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }
}
