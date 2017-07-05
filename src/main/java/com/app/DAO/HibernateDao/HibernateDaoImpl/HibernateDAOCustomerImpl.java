package com.app.DAO.HibernateDao.HibernateDaoImpl;

import com.app.BackendException.DatabaseException;
import com.app.DAO.HibernateDao.HibernateDAOCustomer;
import com.app.DAO.HibernateDao.HibernateDAOGeneral;
import com.app.HibernateEntities.Customer;
import com.app.Utils.SessionFactoryDB;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by User on 05.07.2017.
 */
public class HibernateDAOCustomerImpl extends HibernateDAOGeneral<Integer, Customer> implements HibernateDAOCustomer {

    @Override
    public Optional<Customer> read(Integer key) {
        Transaction transaction = null;
        Customer customer = null;
        try (Session session = SessionFactoryDB.getSession()) {
            transaction = session.beginTransaction();
            customer = session.find(Customer.class, key);//TODO что лучше find или load?
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (RuntimeException e1) {
                    throw new DatabaseException(e1);
                }
            }
            throw new DatabaseException(e);
        }
        return Optional.of(customer);
    }

    @Override
    public List<Customer> getAll() {
        Transaction transaction = null;
        List<Customer> customers = new ArrayList<>();
        try (Session session = SessionFactoryDB.getSession()) {
            transaction = session.beginTransaction();
            customers = (List<Customer>)session.createQuery("FROM Customer").list(); //TODO как тут лучше поступить с "сырыми" данными?
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (RuntimeException e1) {
                    throw new DatabaseException(e1);
                }
            }
            throw new DatabaseException(e);
        }
        return customers;
    }
}
