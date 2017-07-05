package com.app.Utils;

import com.app.DAO.JpaDao.JpaDAOSkill;
import com.app.DAO.JpaDao.JpaDaoImpl.JPADAOSkillImpl;
import com.app.HibernateEntities.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 05.07.2017.
 */
public class EntityFactory {

   static int count = 0;
    public static Developer getDeveloperInstance() {
        count = count + 1;
        JpaDAOSkill daoSkill = new JPADAOSkillImpl();
        List<Skill> skills = new ArrayList<>();
        skills.add(daoSkill.read(1).get());
        skills.add(daoSkill.read(3).get());
        skills.add(daoSkill.read(5).get());

        Developer developer = new Developer("DeveloperName" + count, "DeveloperLastname" + count);
        developer.setSkills(skills);
//        developer.setProjectIDSalary(projectIDSalary);

        return developer;
    }

    public  static Company getCompanyInstance() {
        count = count + 1;
        return new Company("company" + count);
    }

    public  static Customer getCustomerInstance() {
        count = count + 1;
        return new Customer("customer" + count);
    }

    public  static Skill getSkillInstance() {
        count = count + 1;
        return new Skill("skill" + count);

    }

    public static Project getProjectInstance() {
        count = count + 1;
        Company company = new Company("company1");
        company.setId(1);
        Customer customer = new Customer("customer2");
        customer.setId(2);

        return new Project("project"+count, 30000+count, company, customer);
    }
}
