package com.app.DAO.HibernateDao.HibernateDaoImpl;

import com.app.BackendException.DatabaseException;
import com.app.DAO.HibernateDao.HibernateDAODeveloper;
import com.app.DAO.HibernateDao.HibernateDAOGeneral;
import com.app.HibernateEntities.Developer;
import com.app.HibernateEntities.Skill;
import com.app.Utils.SessionFactoryDB;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by User on 05.07.2017.
 */
public class HibernateDAODeveloperImpl extends HibernateDAOGeneral<Integer, Developer> implements HibernateDAODeveloper {

    @Override
    public Optional<Developer> read(Integer key) {
        Transaction transaction = null;
        Developer developer = null;
        try (Session session = SessionFactoryDB.getSession()) {
            transaction = session.beginTransaction();
            developer = session.get(Developer.class, key);// Load  не делает select, а "на слово" верит, что такой developer есть в БД
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
        return Optional.of(developer);
    }

    @Override
    public List<Developer> getAll() {
        Transaction transaction = null;
        List<Developer> developers = new ArrayList<>();
        try (Session session = SessionFactoryDB.getSession()) {
            transaction = session.beginTransaction();
            developers = (List<Developer>) session.createQuery("FROM Developer").list(); //TODO 5. как тут лучше поступить с "сырыми" данными?
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
        return developers;
    }

    public void addDeveloperWithSkills(Developer developer, List<Skill> skills) {
        Transaction transaction = null;

        try (Session session = SessionFactoryDB.getSession()) {
            transaction = session.beginTransaction();
            for (Skill skill : skills) {
                developer.addSkill(skill);
            }
//           skills.forEach(skill-> developer.addSkill(skill));
            session.save(developer);
//            session.flush();//commit автоматически вызовет flush
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
    public void deleteById(Integer id) {
        Transaction transaction = null;
        try (Session session = SessionFactoryDB.getSession()) {
            transaction = session.beginTransaction();

            Developer developer = session.getReference(Developer.class, id);//удаляет и при get, и при getReference
            session.delete(developer);

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

}
