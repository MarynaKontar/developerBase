package com.app;

import com.app.DAO.HibernateDao.*;
import com.app.DAO.HibernateDao.HibernateDaoImpl.*;
import com.app.HibernateEntities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by User on 30.06.2017.
 */
public class HibernateApplication {
    private static int count = 1;

    public static void main(String[] args) {

        HibernateDAODeveloper daoDeveloper = new HibernateDAODeveloperImpl();
        HibernateDAOCompany daoCompany = new HibernateDAOCompanyImpl();
        HibernateDAOCustomer daoCustomer = new HibernateDAOCustomerImpl();
        HibernateDAOSkill daoSkill = new HibernateDAOSkillImpl();
        HibernateDAOProject daoProject = new HibernateDAOProjectImpl();


//--------------------------All Entities ------------------------------
//        System.out.println("-----------Developers----------------");
//        daoDeveloper.getAll().forEach(System.out::println);
//        System.out.println("-----------Developers----------------");
//
//        System.out.println("-----------Companies----------------");
//        daoCompany.getAll().forEach(System.out::println);
//        System.out.println("-----------Companies----------------");

//
//        System.out.println("-----------Customers----------------");
//        daoCustomer.getAll().forEach(System.out::println);
//        System.out.println("-----------Customers----------------");

//        System.out.println("-----------Skills----------------");
//        daoSkill.getAll().forEach(System.out::println);
//        System.out.println("-----------Skills----------------");

//        System.out.println("-----------Projects----------------");
//        daoProject.getAll().forEach(System.out::println);
//        System.out.println("-----------Projects----------------");


//        //------------------------Skill-------------------
//        Skill skill1 = getSkillInstance();
//        daoSkill.create(skill1);
//        Skill skill2 = getSkillInstance();
//        daoSkill.create(skill2);
//        Skill skill3 = getSkillInstance();
//        daoSkill.create(skill3);
//        Skill skill4 = getSkillInstance();
//        daoSkill.create(skill4);
//        Skill skill5 = getSkillInstance();
//        daoSkill.create(skill5);
//        Skill skill6 = getSkillInstance();
//        daoSkill.create(skill6);

//        Skill skill7 = getSkillInstance();
//        skill7.setId(3);
//        daoSkill.update(skill7);
//        System.out.println(daoSkill.read(2));

//        daoSkill.delete(daoSkill.read(6).get());
//        daoSkill.delete(daoSkill.read(5).get());

//        daoSkill.delete(new Skill(5, "skill5"));//TODO не удаляет каскадом

        //------------------------Developer-------------------
//        Developer developer1 = getDeveloperInstance();
//        daoDeveloper.create(developer1);
//        Developer developer2 = getDeveloperInstance();
//        daoDeveloper.create(developer2);
//        System.out.println("-----------Developers----------------");
//        daoDeveloper.getAll().forEach(System.out::println);
//        System.out.println("-----------Developers----------------");
//
//    Developer developer1 = getDeveloperInstance();
//        developer1.setId(4);
//        daoDeveloper.update(developer1);
//
//        System.out.println(daoDeveloper.read(3));
//
//        Developer developer = new Developer("DeveloperName1", "DeveloperLastname1");
//        developer.setId(5);
//        daoDeveloper.delete(developer);

        //------------------------Company-------------------
//        Company company1 = getCompanyInstance();
//        daoCompany.create(company1);
//        Company company2 = getCompanyInstance();
//        daoCompany.create(company2);
//        Company company3 = getCompanyInstance();
//        daoCompany.create(company3);
        //
//        Company company1 = getCompanyInstance();
//        company1.setId(7);
//        daoCompany.update(company1);
//
//        System.out.println(daoCompany.read(7));
//
//        daoCompany.delete(6);

//        //------------------------Customer-------------------
//        Customer customer1 = getCustomerInstance();
//        daoCustomer.create(customer1);
//Customer customer2 = getCustomerInstance();
//        daoCustomer.create(customer2);
//Customer customer3 = getCustomerInstance();
//        daoCustomer.create(customer3);
//
//        Customer customer1 = getCustomerInstance();
//        customer1.setId(2);
//        daoCustomer.update(customer1);
//
//        System.out.println(daoCustomer.read(2));
//
//        daoCustomer.delete(1);

//
//        //------------------------Project-------------------
        Project project = getProjectInstance();
        daoProject.create(project);
        project.addDeveloperWithSalary(daoDeveloper.read(2).get(),2558);


//        Project project1 = getProjectInstance();
//        project1.setId(2);
//        daoProject.update(project1);
//
//        System.out.println(daoProject.read(2));
//
//        daoProject.delete(5);


    }

    static Developer getDeveloperInstance() {
        count = count + 1;
        HibernateDAOSkill daoSkill = new HibernateDAOSkillImpl();
        List<Skill> skills = new ArrayList<>();
        skills.add(daoSkill.read(1).get());
        skills.add(daoSkill.read(3).get());
        skills.add(daoSkill.read(5).get());

//        Map<Integer, Integer> projectIDSalary = new HashMap<>();
//        projectIDSalary.put(1, 5267  + count +1);
//        projectIDSalary.put(6, 4340 + count+1);

        Developer developer = new Developer("DeveloperName" + count, "DeveloperLastname" + count);
        developer.setSkills(skills);
//        developer.setProjectIDSalary(projectIDSalary);

        return developer;
    }

    static Company getCompanyInstance() {
        count = count + 1;
        return new Company("company" + count);
    }

    static Customer getCustomerInstance() {
        count = count + 1;
        return new Customer("customer" + count);
    }

    static Skill getSkillInstance() {
        count = count + 1;
        return new Skill("skill" + count);

    }

    static Project getProjectInstance() {
        count = count + 1;
        Company company = new Company("company2");
        company.setId(5);
        Customer customer = new Customer("customer6");
        customer.setId(6);

       return new Project("project"+count, 30000+count, company, customer);
    }
}

