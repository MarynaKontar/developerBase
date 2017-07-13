package com.app.DAO.HibernateDao.HibernateDaoImpl;

import com.app.BackendException.DatabaseException;
import com.app.DAO.HibernateDao.HibernateDAOGeneral;
import com.app.DAO.HibernateDao.HibernateDAOProject;
import com.app.HibernateEntities.Developer;
import com.app.HibernateEntities.DeveloperProject;
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
            project = session.get(Project.class, key);
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
            projects = (List<Project>) session.createQuery("FROM Project").list(); //TODO как тут лучше поступить с "сырыми" данными?
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


    //TODO 9. сначала у меня не получалось добавить DeveloperToProject при использовании get, а получилось при getReference.
    // Но теперь выходит и с get, и с getReference,  и с find,  и с load. И я так и не поняла,
    // что же я такое сделала, что все стало выходить.
    //Я думала, что с getReference получается потому что entity находится в состоянии managed, но теперь не понимаю,
    // почему выходит при get, find, load
    @Override
    public void addDeveloperToProject(Integer developerId, int salary, Integer projectId) {
        Transaction transaction = null;

        try (Session session = SessionFactoryDB.getSession()) {
            transaction = session.beginTransaction();
            Project project = session.get(Project.class, projectId);
            Developer developer = session.get(Developer.class, developerId);
            project.addDeveloperWithSalary(developer, salary);
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
    public void addDeveloperAndProject(Project project, Developer developer, int salary) {
        Transaction transaction = null;
        try (Session session = SessionFactoryDB.getSession()) {
            transaction = session.beginTransaction();
            session.save(developer);
            session.save(project);
            project.addDeveloperWithSalary(developer, salary);
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

    //TODO 6. в removeDeveloper будет удалять по equals.
//И даже если я не @Override equals в Project  и Developer, все равно получаются equals project и developer.
// Т.е. получается, что "подтянутые" с помощью "get" project и developer внутри содержат PersistenceBag
// (для project - PersistenceBag developers, а для developer - PersistenceBag projects).
// И эти PersistenceBag ссылаются на одни и те же ячейки памяти, т. е. для equals в Object - это один и тот же объект????
    @Override
    public void removeDeveloperFromProject(Integer developerId, Integer projectId) {
        Transaction transaction = null;

        try (Session session = SessionFactoryDB.getSession()) {
            transaction = session.beginTransaction();
            Project project = session.get(Project.class, projectId);
            Developer developer = session.get(Developer.class, developerId);
            project.removeDeveloper(developer);
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
    public List<DeveloperProject> getAllDevelopersFromProject(Integer projectId) {
        Transaction transaction = null;
        Project project = null;
        List<DeveloperProject> developers;
        try (Session session = SessionFactoryDB.getSession()) {
            transaction = session.beginTransaction();
            project = session.get(Project.class, projectId);
            developers = project.getDevelopers();

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
//        if (project !=null){
//        List<DeveloperProject> developers = project.getDevelopers();
//        return developers;
        return (List<DeveloperProject>)developers;
    }
}

