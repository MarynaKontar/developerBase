package com.app;

import com.app.DAO.HibernateDao.*;
import com.app.DAO.HibernateDao.HibernateDaoImpl.*;
import com.app.HibernateEntities.*;
import com.app.Utils.SessionFactoryDB;

import java.util.ArrayList;
import java.util.List;

import static com.app.Utils.EntityFactory.*;

/**
 * Created by User on 05.07.2017.
 */
public class HibernateApplication {
    public static void main(String[] args) {
        try {
            HibernateDAODeveloper daoDeveloper = new HibernateDAODeveloperImpl();
            HibernateDAOCompany daoCompany = new HibernateDAOCompanyImpl();
            HibernateDAOCustomer daoCustomer = new HibernateDAOCustomerImpl();
            HibernateDAOSkill daoSkill = new HibernateDAOSkillImpl();
            HibernateDAOProject daoProject = new HibernateDAOProjectImpl();


//--------------------------All Entities ------------------------------
//            System.out.println("-----------Developers----------------");
//            daoDeveloper.getAll().forEach(System.out::println);
//            System.out.println("-----------Developers----------------");
//
//        System.out.println("-----------Companies----------------");
//        daoCompany.getAll().forEach(System.out::println);
//        System.out.println("-----------Companies----------------");
//
//
//        System.out.println("-----------Customers----------------");
//        daoCustomer.getAll().forEach(System.out::println);
//        System.out.println("-----------Customers----------------");
//
//        System.out.println("-----------Skills----------------");
//        daoSkill.getAll().forEach(System.out::println);
//        System.out.println("-----------Skills----------------");
//
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
//        skill7.setId(6);
//            System.out.println(skill7);
//        daoSkill.update(skill7);
//        System.out.println(daoSkill.read(6));

//        daoSkill.delete(daoSkill.read(7).get());
//        daoSkill.delete(daoSkill.read(5).get());

//        daoSkill.delete(new Skill(5, "skill5"));//TODO не удаляет каскадом

            //------------------------Developer-------------------
//        Developer developer1 = getDeveloperInstance();//TODO при create и update девелопера не закрывается фабрика - видимо из-за того, что проекты не созданы
//        daoDeveloper.create(developer1);
//        Developer developer2 = getDeveloperInstance();
//        daoDeveloper.create(developer2);
//        System.out.println("-----------Developers----------------");
//        daoDeveloper.getAll().forEach(System.out::println);
//        System.out.println("-----------Developers----------------");
//
//    Developer developer1 = getDeveloperInstance();
//        developer1.setId(6);
//        developer1.setName("ffghuj");
//        daoDeveloper.update(developer1);
////
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
//            //
//        Company company4 = getCompanyInstance();
//        company4.setId(2);
//        daoCompany.update(company4);
////
//        System.out.println(daoCompany.read(2));
//
//        daoCompany.delete(company4);

//        //------------------------Customer-------------------
//        Customer customer1 = getCustomerInstance();
//        daoCustomer.create(customer1);
//Customer customer2 = getCustomerInstance();
//        daoCustomer.create(customer2);
//Customer customer3 = getCustomerInstance();
//        daoCustomer.create(customer3);
//
//        Customer customer4 = getCustomerInstance();
//        customer4.setId(2);
//        daoCustomer.update(customer4);
//
//        System.out.println(daoCustomer.read(2));
//
//            Customer customer5 = getCustomerInstance();
//            customer5.setId(1);
//            daoCustomer.delete(customer5);

//
//        //------------------------Project-------------------
        Project project1 = getProjectInstance();
        daoProject.create(project1);
        project1
                .addDeveloperWithSalary(
                        daoDeveloper.read(2).get(),2558);

//            Project project2 = getProjectInstance();
//            daoProject.create(project2);
//            project2.addDeveloperWithSalary(daoDeveloper.read(2).get(),3000);
//
//
//            Project project3 = getProjectInstance();
//            daoProject.create(project3);
//            project3.addDeveloperWithSalary(daoDeveloper.read(3).get(),4000);
//
//            Project project4 = getProjectInstance();
//            daoProject.create(project4);
//            project4.addDeveloperWithSalary(daoDeveloper.read(4).get(),2000);
//
//
//        Project project5 = getProjectInstance();
//        project5.setId(2);
//        daoProject.update(project5);
////
//        System.out.println(daoProject.read(2));
//
//        daoProject.delete(5);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SessionFactoryDB.getSessionFactory().close();
        }
    }
}
