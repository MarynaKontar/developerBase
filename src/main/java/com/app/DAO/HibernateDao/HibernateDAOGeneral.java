package com.app.DAO.HibernateDao;

import com.app.BackendException.DatabaseException;
import com.app.DAO.DAO;
import com.app.Utils.EMFactory;
import com.app.Utils.SessionFactoryDB;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Optional;

/**
 * Created by User on 27.06.2017.
 */
public abstract class HibernateDAOGeneral<K extends Serializable, T> implements DAO<K, T> {


    @Override
    public void create(T entity) {
        Transaction transaction = null;
        try (Session session = SessionFactoryDB.getSession()) {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (RuntimeException e) { //catch RuntimeException but not HibernateException because beginTransaction() and commit() can throw IllegalStateException
            if (transaction != null) {
                try {
                    transaction.rollback();  //throw TransactionException (extends HibernateException extends PersistenceException  extends RuntimeException) and IllegalStateException (extends RuntimeException)
                } catch (RuntimeException e1) {
                    throw new DatabaseException(e1);
                }
            }
            throw new DatabaseException(e);
        }
    }

    @Override
    public void update(T entity) {
        Transaction transaction = null;
        try (Session session = SessionFactoryDB.getSession()) {
            transaction = session.beginTransaction();
            session.update(entity);
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
    }

    @Override
    public void delete(T entity) {
        Transaction transaction = null;
        try (Session session = SessionFactoryDB.getSession()) {
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (RuntimeException e1) {
                    throw new DatabaseException(e1);
                }
            }
        }
    }
}


