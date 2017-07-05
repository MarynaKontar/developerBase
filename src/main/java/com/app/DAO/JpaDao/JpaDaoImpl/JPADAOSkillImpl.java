package com.app.DAO.JpaDao.JpaDaoImpl;

import com.app.DAO.JpaDao.JPADAOGeneral;
import com.app.DAO.JpaDao.JpaDAOSkill;
import com.app.HibernateEntities.Skill;
import com.app.Utils.EMFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * Created by User on 27.06.2017.
 */
public class JPADAOSkillImpl extends JPADAOGeneral<Integer, Skill> implements JpaDAOSkill {
    @Override
    public Optional<Skill> read(Integer key) {
        EntityManager em = EMFactory.getEntityManager();
        em.getTransaction().begin();
        Skill entity = em.find(Skill.class, key);
        em.getTransaction().commit();
        return Optional.ofNullable(entity);
    }

    @Override
    public void delete(Skill entity) {
        EntityManager em = EMFactory.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.getReference(Skill.class, entity.getId()));

        em.getTransaction().commit();
    }

    @Override
    public List<Skill> getAll() {
        EntityManager em = EMFactory.getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Skill> typedQuery = em.createNamedQuery("Skill.getAll", Skill.class);
        List<Skill> skills = typedQuery.getResultList();
        em.getTransaction().commit();
        return skills;
    }
}
