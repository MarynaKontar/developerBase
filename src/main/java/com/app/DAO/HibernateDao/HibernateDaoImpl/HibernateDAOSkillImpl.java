package com.app.DAO.HibernateDao.HibernateDaoImpl;

import com.app.BackendException.DatabaseException;
import com.app.DAO.HibernateDao.HibernateDAOGeneral;
import com.app.DAO.HibernateDao.HibernateDAOSkill;
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
            skill = session.find(Skill.class, key);//TODO что лучше find или load?
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
}
