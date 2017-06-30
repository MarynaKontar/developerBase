package com.app;

import com.app.DAO.*;
import com.app.DAO.JdbcDao.*;
import com.app.Entities.*;

import java.util.*;

/**
 * Created by User on 04.06.2017.
 */
public class Main {
    private static int count = 2;

    public static void main(String[] args) {

        DAODeveloper daoDeveloper = new JdbcDAODeveloper();
        DAOCompany daoCompany = new JdbcDAOCompany();
        DAOCustomer daoCustomer = new JdbcDAOCustomer();
        DAOSkill daoSkill = new JdbcDAOSkill();
        DAOProject daoProject = new JdbcDAOProject();

//--------------------------All Entities ------------------------------
//        System.out.println("-----------Developers----------------");
//        daoDeveloper.getAll().forEach(System.out::println);
////        List<Developer> developers = daoDeveloper.getAll();
////        for (Developer developer : developers) {
////            System.out.println(developer);
////        }
//
//        System.out.println("-----------Companies----------------");
//        daoCompany.getAll().forEach(System.out::println);
////        List<Company> companies = daoCompany.getAll();
////        for (Company company : companies) {
////            System.out.println(company);
////        }
//
//        System.out.println("-----------Customers----------------");
//        daoCustomer.getAll().forEach(System.out::println);
////        List<Customer> customers = daoCustomer.getAll();
////        for (Customer customer : customers) {
////            System.out.println(customer);
////        }
//
//        System.out.println("-----------Skills----------------");
//        daoSkill.getAll().forEach(System.out::println);
////        List<Skill> skills = daoSkill.getAll();
////        for (Skill skill : skills) {
////            System.out.println(skill);
////        }
//
//        System.out.println("-----------Projects----------------");
//        daoProject.getAll().forEach(System.out::println);
////        List<Project> projects = daoProject.getAll();
////        for (Project project : projects) {
////            System.out.println(project);
////        }


        //------------------------Developer-------------------
//        Developer developer = getDeveloperInstance();
//        daoDeveloper.create(developer);
//
        Developer developer1 = getDeveloperInstance();
        developer1.setId(4);
        daoDeveloper.update(developer1);
//
//        System.out.println(daoDeveloper.read(3));
//
//        daoDeveloper.delete(6);

        //------------------------Company-------------------
//        Company company = getCompanyInstance();
//        daoCompany.create(company);
//
//        Company company1 = getCompanyInstance();
//        company1.setId(7);
//        daoCompany.update(company1);
//
//        System.out.println(daoCompany.read(7));
//
//        daoCompany.delete(6);

//        //------------------------Customer-------------------
//       Customer customer = getCustomerInstance();
//        daoCustomer.create(customer);
//
//        Customer customer1 = getCustomerInstance();
//        customer1.setId(2);
//        daoCustomer.update(customer1);
//
//        System.out.println(daoCustomer.read(2));
//
//        daoCustomer.delete(1);

//
//        //------------------------Skill-------------------
//        Skill skill = getSkillInstance();
//        daoSkill.create(skill);
//
//        Skill skill1 = getSkillInstance();
//        skill1.setId(2);
//        daoSkill.update(skill1);
//
//        System.out.println(daoSkill.read(2));
//
//        daoSkill.delete(5);
//
//        //------------------------Project-------------------
//        Project project = getProjectInstance();
//        daoProject.create(project);
//
//        Project project1 = getProjectInstance();
//        project1.setId(2);
//        daoProject.update(project1);
//
//        System.out.println(daoProject.read(2));
//
//        daoProject.delete(5);





    }

    static Developer getDeveloperInstance() {
        List<Integer> skillIdList = Arrays.asList(new Integer[]{1, 3, 8});

        Map<Integer, Integer> projectIDSalary = new HashMap<>();
        projectIDSalary.put(1, 5267  + count +1);
        projectIDSalary.put(6, 4340 + count+1);

        Developer developer = new Developer("DeveloperName" + count, "DeveloperLastname" + count);
        developer.setSkillIdList(skillIdList);
        developer.setProjectIDSalary(projectIDSalary);

    return developer;
    }

    static Company getCompanyInstance(){

        return new Company("company" + count);
    }

    static Customer getCustomerInstance(){

        return new Customer("customer" + count);
    }

    static Skill getSkillInstance(){

        return new Skill("skill" + count);
    }

    static Project getProjectInstance(){

        return new Project("project" + count, 30000 + count, 4, 3);
    }
}
