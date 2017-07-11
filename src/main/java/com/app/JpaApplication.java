package com.app;

import com.app.DAO.JpaDao.*;
import com.app.DAO.JpaDao.JpaDaoImpl.*;
import com.app.HibernateEntities.*;
import com.app.Utils.EMFactory;

import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 30.06.2017.
 */
public class JpaApplication {
    private static int count = 1;

    public static void main(String[] args) {
        try {
            JpaDAODeveloper daoDeveloper = new JPADAODeveloperImpl();
            JpaDAOCompany daoCompany = new JPADAOCompanyImpl();
            JpaDAOCustomer daoCustomer = new JPADAOCustomerImpl();
            JpaDAOSkill daoSkill = new JPADAOSkillImpl();
            JpaDAOProject daoProject = new JPADAOProjectImpl();


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

            Skill skill7 = getSkillInstance();
            skill7.setId(3);
            daoSkill.update(skill7);
            System.out.println(daoSkill.read(2));

            daoSkill.delete(daoSkill.read(6).get());

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
            daoDeveloper.update(developer6);

            System.out.println(daoDeveloper.read(3));

            Developer developer = new Developer("DeveloperName1", "DeveloperLastname1");
            developer.setId(5);
            daoDeveloper.delete(developer);

//        daoSkill.delete(new Skill(5, "skill5"));
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

//        Project project5 = daoProject.read(1).get(); //TODO НЕ СОЗДАЕТ!!!
//        project5
//                .addDeveloperWithSalary(
//                        daoDeveloper.read(2).get(), 2558);
//
//
//            project2.addDeveloperWithSalary(daoDeveloper.read(2).get(),3000);

//
//            project3.addDeveloperWithSalary(daoDeveloper.read(3).get(),4000);

//            project4.addDeveloperWithSalary(daoDeveloper.read(4).get(),2000);

//        Project project5 = getProjectInstance();
//        project5.setId(2);
//        daoProject.update(project5);
//
//        System.out.println(daoProject.read(2));
//

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            EntityManagerFactory entityManagerFactory = EMFactory.getEntityManagerFactory();
            entityManagerFactory.close();
        }
    }

    static Developer getDeveloperInstance() {
        count = count + 1;
        JpaDAOSkill daoSkill = new JPADAOSkillImpl();
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
        Company company = new Company("company1");
        company.setId(1);
        Customer customer = new Customer("customer2");
        customer.setId(2);

        return new Project("project" + count, 30000 + count, company, customer);
    }
}

