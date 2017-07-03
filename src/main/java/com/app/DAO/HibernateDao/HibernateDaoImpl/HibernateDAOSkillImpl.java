package com.app.DAO.HibernateDao.HibernateDaoImpl;


import com.app.DAO.HibernateDao.HibernateDAOGeneral;
import com.app.DAO.HibernateDao.HibernateDAOSkill;
import com.app.HibernateEntities.Skill;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * Created by User on 27.06.2017.
 */
public class HibernateDAOSkillImpl extends HibernateDAOGeneral<Integer, Skill> implements HibernateDAOSkill{
    @Override
    public Optional<Skill> read(Integer key) {
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Skill entity = em.find(Skill.class, key);
        em.getTransaction().commit();
        return Optional.ofNullable(entity);
    }

    @Override
    public void delete(Skill entity) {
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.getReference(Skill.class, entity.getId()));

        em.getTransaction().commit();
    }

    @Override
    public List<Skill> getAll() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Skill> typedQuery = em.createNamedQuery("Skill.getAll", Skill.class);
        List<Skill> skills = typedQuery.getResultList();
        em.getTransaction().commit();
        return skills;
    }
}
