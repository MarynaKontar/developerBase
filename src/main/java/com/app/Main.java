package com.app;

import com.app.DAO.*;
import com.app.DAO.JdbcDao.*;
import com.app.Entities.*;

import java.util.*;

/**
 * Created by User on 04.06.2017.
 */
public class Main {
    public static void main(String[] args) {

        DAODeveloper daoDeveloper = new JdbcDAODeveloper();
        DAOCompany daoCompany = new JdbcDAOCompany();
        DAOCustomer daoCustomer = new JdbcDAOCustomer();
        DAOSkill daoSkill = new JdbcDAOSkill();
        DAOProject daoProject = new JdbcDAOProject();


//        List<Integer> skillIdList = Arrays.asList(new Integer[] {1,3,8});
//
//        Map<Integer, Integer> projectIDSalary = new HashMap<>();
//        projectIDSalary.put(1,1267);
//        projectIDSalary.put(6,1340);
//
//        Developer developer = new Developer("Andrey", "Minov");
//        developer.setSkillIdList(skillIdList);
//        developer.setProjectIDSalary(projectIDSalary);
//
//
//
//
//
        List<Integer> skillIdList1 = Arrays.asList(new Integer[]{6, 8, 14});

        Map<Integer, Integer> projectIDSalary1 = new HashMap<>();
        projectIDSalary1.put(3, 155555);
        projectIDSalary1.put(6, 255555);

        Developer developer1 = new Developer("A", "R");
        developer1.setSkillIdList(skillIdList1);
        developer1.setProjectIDSalary(projectIDSalary1);
        developer1.setId(20);
//        daoDeveloper.update(developer1);
        daoDeveloper.delete(38);



        List<Developer> developers = daoDeveloper.getAll();
        for (Developer developer : developers) {
            System.out.println(developer);
        }

        List<Company> companies = daoCompany.getAll();
        for (Company company : companies) {
            System.out.println(company);
        }

        List<Customer> customers = daoCustomer.getAll();
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        List<Skill> skills = daoSkill.getAll();
        for (Skill skill : skills) {
            System.out.println(skill);
        }

        List<Project> projects = daoProject.getAll();
        for (Project project : projects) {
            System.out.println(project);
        }

        //
//        daoDeveloper.create(developer);
//        daoDeveloper.create(developer1);

//        System.out.println(daoDeveloper.read(23));

    }
}
