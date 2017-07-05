package com.app.DAO.HibernateDao.HibernateDaoImpl;

import com.app.BackendException.DatabaseException;
import com.app.DAO.HibernateDao.HibernateDAOCompany;
import com.app.DAO.HibernateDao.HibernateDAOGeneral;
import com.app.HibernateEntities.Company;
import com.app.Utils.SessionFactoryDB;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by User on 05.07.2017.
 */
public class HibernateDAOCompanyImpl extends HibernateDAOGeneral<Integer, Company> implements HibernateDAOCompany {

    @Override
    public Optional<Company> read(Integer key) {
        Transaction transaction = null;
        Company company = null;
        try (Session session = SessionFactoryDB.getSession()) {
            transaction = session.beginTransaction();
            company = session.find(Company.class, key);//TODO что лучше find или load?
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
        return Optional.of(company);
    }

    @Override
    public List<Company> getAll() {
        Transaction transaction = null;
        List<Company> companies = new ArrayList<>();
        try (Session session = SessionFactoryDB.getSession()) {
            transaction = session.beginTransaction();
            companies = (List<Company>)session.createQuery("FROM Company").list(); //TODO как тут лучше поступить с "сырыми" данными?
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
        return companies;
    }
}
