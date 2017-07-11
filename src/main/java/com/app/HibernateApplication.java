package com.app;

import com.app.BackendException.DatabaseException;
import com.app.DAO.HibernateDao.*;
import com.app.DAO.HibernateDao.HibernateDaoImpl.*;
import com.app.HibernateEntities.*;
import com.app.Utils.SessionFactoryDB;
import org.hibernate.HibernateException;

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
//            Skill skill1 = getSkillInstance();
//            daoSkill.create(skill1);
//            Skill skill2 = getSkillInstance();
//            daoSkill.create(skill2);
//            Skill skill3 = getSkillInstance();
//            daoSkill.create(skill3);
//            Skill skill4 = getSkillInstance();
//            daoSkill.create(skill4);
//            Skill skill5 = getSkillInstance();
//            daoSkill.create(skill5);
//            Skill skill6 = getSkillInstance();
//            daoSkill.create(skill6);
////
//            Skill skill7 = getSkillInstance();
//            skill7.setId(3);
//            daoSkill.update(skill7);
//
//            System.out.println(daoSkill.read(2));
//
//            daoSkill.delete(daoSkill.read(6).get());
//
//            //------------------------Developer-------------------
//            Developer developer1 = getDeveloperInstance();
//            daoDeveloper.create(developer1);
//            Developer developer2 = getDeveloperInstance();
//            daoDeveloper.create(developer2);
//            Developer developer3 = getDeveloperInstance();
//            daoDeveloper.create(developer3);
//            Developer developer4 = getDeveloperInstance();
//            daoDeveloper.create(developer4);
//            Developer developer5 = getDeveloperInstance();
//            daoDeveloper.create(developer5);
//
//            System.out.println("-----------Developers----------------");
//            daoDeveloper.getAll().forEach(System.out::println);
//            System.out.println("-----------Developers----------------");
//
//            Developer developer6 = getDeveloperInstance();
//            developer6.setId(4);
//            developer6.setName("ffghuj");
//            daoDeveloper.update(developer6);
//
//            System.out.println(daoDeveloper.read(3));
//
//            Developer developer = new Developer("DeveloperName1", "DeveloperLastname1");
//            developer.setId(5);
//            daoDeveloper.delete(developer);
//
////        daoSkill.delete(new Skill(5, "skill5"));
//            //------------------------Company-------------------
//            Company company1 = getCompanyInstance();
//            daoCompany.create(company1);
//            Company company2 = getCompanyInstance();
//            daoCompany.create(company2);
//            Company company3 = getCompanyInstance();
//            daoCompany.create(company3);
//
//            Company company4 = getCompanyInstance();
//            company4.setId(2);
//            daoCompany.update(company4);
//
//            System.out.println(daoCompany.read(2));
//
//            daoCompany.delete(company4);
//
////        //------------------------Customer-------------------
//            Customer customer1 = getCustomerInstance();
//            daoCustomer.create(customer1);
//            Customer customer2 = getCustomerInstance();
//            daoCustomer.create(customer2);
//            Customer customer3 = getCustomerInstance();
//            daoCustomer.create(customer3);
//
//            Customer customer4 = getCustomerInstance();
//            customer4.setId(2);
//            daoCustomer.update(customer4);
//
//            System.out.println(daoCustomer.read(2));
//
//            Customer customer5 = getCustomerInstance();
//            customer5.setId(1);
//            daoCustomer.delete(customer5);
//
////
////        //------------------------Project-------------------
//            Project project1 = getProjectInstance();
//            daoProject.create(project1);
//            Project project2 = getProjectInstance();
//            daoProject.create(project2);
//            Project project3 = getProjectInstance();
//            daoProject.create(project3);
//            Project project4 = getProjectInstance();
//            daoProject.create(project4);


//            daoProject.addDeveloperAndProject(getProjectInstance(),getDeveloperInstance(), 4455);
            daoProject.addDeveloperToProject(3,1000, 4);
//
//        Project project5 = getProjectInstance();
//        project5.setId(2);
//        project5.setName("ddddddd");
//        project5.setCost(11111111);
//        daoProject.update(project5);
//
//        System.out.println(daoProject.read(2));
//


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                SessionFactoryDB.getSessionFactory().close();
            } catch(HibernateException e){
                throw new DatabaseException(e);
            }
        }
    }
}
