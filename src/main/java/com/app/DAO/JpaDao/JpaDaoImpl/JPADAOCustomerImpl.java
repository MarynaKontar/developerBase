package com.app.DAO.JpaDao.JpaDaoImpl;

import com.app.DAO.JpaDao.JPADAOGeneral;
import com.app.DAO.JpaDao.JpaDAOCustomer;
import com.app.HibernateEntities.Customer;
import com.app.Utils.EMFactory;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * Created by User on 27.06.2017.
 */
public class JPADAOCustomerImpl extends JPADAOGeneral<Integer, Customer> implements JpaDAOCustomer {
    @Override
    public Optional<Customer> read(Integer key) {
        EntityManager em = EMFactory.getEntityManager();
        em.getTransaction().begin();
        Customer entity = em.find(Customer.class, key);
        em.getTransaction().commit();
        return Optional.ofNullable(entity);
    }

    @Override
    public void delete(Customer entity) {
        EntityManager em = EMFactory.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.getReference(Customer.class, entity.getId()));
        em.getTransaction().commit();
    }

    @Override
    public List<Customer> getAll() {
        EntityManager em = EMFactory.getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Customer> typedQuery = em.createNamedQuery("Customer.getAll",Customer.class);
        List<Customer> customers = typedQuery.getResultList();
        em.getTransaction().commit();
        return customers;
    }
}
