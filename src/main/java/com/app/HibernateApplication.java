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

//TODO 1. если запустить этот файл при  <property name="hbm2ddl.auto">create</property>, то он не закрывается сам
// (не выдает Process finished with exit code 0), приходится останавливать вручную - Stop
// хотя фабрика вроде закрівается, пишет, что
// [main] DEBUG org.hibernate.internal.SessionFactoryImpl - HHH000031: Closing
//Не понимаю, почему так происходит. В режиме update - все нормально.
public class HibernateApplication {
    public static void main(String[] args) {
        try {
            HibernateDAODeveloper daoDeveloper = new HibernateDAODeveloperImpl();
            HibernateDAOCompany daoCompany = new HibernateDAOCompanyImpl();
            HibernateDAOCustomer daoCustomer = new HibernateDAOCustomerImpl();
            HibernateDAOSkill daoSkill = new HibernateDAOSkillImpl();
            HibernateDAOProject daoProject = new HibernateDAOProjectImpl();


            //------------------------Skill-------------------
            Skill skill1 = getSkillInstance();
            daoSkill.create(skill1);
            Skill skill2 = getSkillInstance();
            daoSkill.create(skill2);
            Skill skill3 = getSkillInstance();
            daoSkill.create(skill3);
            Skill skill4 = getSkillInstance();
            daoSkill.create(skill4);
            Skill skill5 = getSkillInstance();
            daoSkill.create(skill5);
            Skill skill6 = getSkillInstance();
            daoSkill.create(skill6);
//
            Skill skill7 = getSkillInstance();
            skill7.setId(3);
            daoSkill.update(skill7);

           // System.out.println(daoSkill.read(2));

           // daoSkill.delete(daoSkill.read(6).get());

            //------------------------Developer-------------------
            Developer developer1 = getDeveloperInstance();
            daoDeveloper.create(developer1);
            Developer developer2 = getDeveloperInstance();
            daoDeveloper.create(developer2);
            Developer developer3 = getDeveloperInstance();
            daoDeveloper.create(developer3);
            Developer developer4 = getDeveloperInstance();
            daoDeveloper.create(developer4);
            Developer developer5 = getDeveloperInstance();
            daoDeveloper.create(developer5);

            System.out.println("-----------Developers----------------");
            daoDeveloper.getAll().forEach(System.out::println);
            System.out.println("-----------Developers----------------");

            Developer developer6 = getDeveloperInstance();
            developer6.setId(4);
            developer6.setName("ffghuj");
            daoDeveloper.update(developer6);

//           // System.out.println(daoDeveloper.read(3));


            //------------------------Company-------------------
            Company company1 = getCompanyInstance();
            daoCompany.create(company1);
            Company company2 = getCompanyInstance();
            daoCompany.create(company2);
            Company company3 = getCompanyInstance();
            daoCompany.create(company3);

            Company company4 = getCompanyInstance();
            company4.setId(2);
            daoCompany.update(company4);

            System.out.println(daoCompany.read(2));

            daoCompany.delete(company4);

//        //------------------------Customer-------------------
            Customer customer1 = getCustomerInstance();
            daoCustomer.create(customer1);
            Customer customer2 = getCustomerInstance();
            daoCustomer.create(customer2);
            Customer customer3 = getCustomerInstance();
            daoCustomer.create(customer3);

            Customer customer4 = getCustomerInstance();
            customer4.setId(2);
            daoCustomer.update(customer4);

            System.out.println(daoCustomer.read(2));

            Customer customer5 = getCustomerInstance();
            customer5.setId(1);
            daoCustomer.delete(customer5);

//
//        //------------------------Project-------------------
            Project project1 = getProjectInstance();
            daoProject.create(project1);
            Project project2 = getProjectInstance();
            daoProject.create(project2);
            Project project3 = getProjectInstance();
            daoProject.create(project3);
            Project project4 = getProjectInstance();
            daoProject.create(project4);

            daoProject.addDeveloperAndProject(getProjectInstance(), getDeveloperInstance(), 4455);
            daoProject.addDeveloperToProject(1, 1550, 2);
            daoProject.addDeveloperToProject(3, 1660, 2);
            daoProject.addDeveloperToProject(3, 1460, 3);
            daoProject.addDeveloperToProject(4, 1780, 2);
            daoProject.addDeveloperToProject(4, 1900, 4);

            daoProject.removeDeveloperFromProject(3, 3);

            Project project5 = getProjectInstance();
            project5.setId(2);
            project5.setName("ddddddd");
            project5.setCost(11111111);
            daoProject.update(project5);

            System.out.println(daoProject.read(2));
//
//
//            //TODO 2. Почему при удалении developer в состоянии detached, отказывается удалать из-за того, что этот developer есть в таблицах developer_skill и developer_project?
//            // в документации написано, что можно в hibernate удалять в detached статусе
//            //http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#pc-remove
//            Developer developer = new Developer("DeveloperName28","DeveloperLastname28");
//            developer.setId(4);
//            daoDeveloper.delete(developer);
//
//           //TODO 3. Опять таки здесь я могу удалить developer со skills и projects только, если функция read вызывает getReference,
//            // а если get - то могу удалить только developer, у которого нет skills и projects (нет в таблтицах developer_skill и developer_project)
//            daoDeveloper.delete(daoDeveloper.read(4).get());


            //           //TODO 4. Может надо писать в dao только метод deleteById, и не мучаться с методом delete? Как обычно делают?
            daoDeveloper.deleteById(6);
//
//
//        //daoSkill.deleteById(5);
//
////            --------------------------All Entities ------------------------------
//            System.out.println("-----------Developers----------------");
//            daoDeveloper.getAll().forEach(System.out::println);
//            System.out.println("-----------Developers----------------");
//
//            System.out.println("-----------Companies----------------");
//            daoCompany.getAll().forEach(System.out::println);
//            System.out.println("-----------Companies----------------");
//
//
//            System.out.println("-----------Customers----------------");
//            daoCustomer.getAll().forEach(System.out::println);
//            System.out.println("-----------Customers----------------");
//
//            System.out.println("-----------Skills----------------");
//            daoSkill.getAll().forEach(System.out::println);
//            System.out.println("-----------Skills----------------");
//
//            System.out.println("-----------Projects----------------");
//            daoProject.getAll().forEach(System.out::println);
//            System.out.println("-----------Projects----------------");
//
//
//
////            TODO в debug режиме developers.forEach(System.out::println) все выводит, а если просто запустить, то выдает
////             org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: com.app.HibernateEntities.Project.developers, could not initialize proxy - no Session
////            Причем при debug, видно что переменная developers - PersistenceBag, а не просто List. Видимо из-за этого Exception. Не знаю как решить эту проблему
//            System.out.println("-----------Project's developers----------------");
//            List<DeveloperProject> developers = daoProject.getAllDevelopersFromProject(2);
////            developers.forEach(System.out::println);
//            System.out.println("-----------Project's developers----------------");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                SessionFactoryDB.getSessionFactory().close();
            } catch (HibernateException e) {
                throw new DatabaseException(e);
            }
        }
    }
}
