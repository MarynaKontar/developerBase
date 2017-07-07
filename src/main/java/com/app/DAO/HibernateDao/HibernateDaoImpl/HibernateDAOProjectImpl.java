package com.app.DAO.HibernateDao.HibernateDaoImpl;

import com.app.BackendException.DatabaseException;
import com.app.DAO.HibernateDao.HibernateDAOGeneral;
import com.app.DAO.HibernateDao.HibernateDAOProject;
import com.app.HibernateEntities.Project;
import com.app.Utils.SessionFactoryDB;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by User on 05.07.2017.
 */
public class HibernateDAOProjectImpl extends HibernateDAOGeneral<Integer, Project> implements HibernateDAOProject {


    @Override
    public Optional<Project> read(Integer key) {
        Transaction transaction = null;
        Project project = null;
        try (Session session = SessionFactoryDB.getSession()) {
            transaction = session.beginTransaction();
            project = session.load(Project.class, key);//TODO что лучше find или load?
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
        return Optional.of(project);
    }

    @Override
    public List<Project> getAll() {
        Transaction transaction = null;
        List<Project> projects = new ArrayList<>();
        try (Session session = SessionFactoryDB.getSession()) {
            transaction = session.beginTransaction();
            projects = (List<Project>)session.createQuery("FROM Project").list(); //TODO как тут лучше поступить с "сырыми" данными?
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
        return projects;
    }
}
