package com.app.DAO.HibernateDao.HibernateDaoImpl;

import com.app.BackendException.DatabaseException;
import com.app.DAO.HibernateDao.HibernateDAODeveloper;
import com.app.DAO.HibernateDao.HibernateDAOGeneral;
import com.app.DAO.HibernateDao.HibernateDAOSkill;
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
public class HibernateDAOSkillImpl extends HibernateDAOGeneral<Integer, Skill> implements HibernateDAOSkill {


    @Override
    public Optional<Skill> read(Integer key) {
        Transaction transaction = null;
        Skill skill = null;
        try (Session session = SessionFactoryDB.getSession()) {
            transaction = session.beginTransaction();
            skill = session.get(Skill.class, key);
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
        return Optional.of(skill);
    }

    @Override
    public List<Skill> getAll() {
        Transaction transaction = null;
        List<Skill> skills = new ArrayList<>();
        try (Session session = SessionFactoryDB.getSession()) {
            transaction = session.beginTransaction();
            skills = (List<Skill>)session.createQuery("FROM Skill").list(); //TODO как тут лучше поступить с "сырыми" данными?
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
        return skills;
    }



    // TODO 7. Не вышло. Опять видимо что-то неправильно с состояниями entity
    @Override
    public void deleteById(Integer id){
        Transaction transaction = null;
    List<Developer> developers = new ArrayList<>();
    try (Session session = SessionFactoryDB.getSession()) {
            transaction = session.beginTransaction();
           Skill skill = session.getReference(Skill.class, id);
        developers = (List<Developer>) session.createQuery("FROM Developer").list();
        developers.forEach(developer -> developer.removeSkill(read(id).get()));
            session.delete(skill);
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
