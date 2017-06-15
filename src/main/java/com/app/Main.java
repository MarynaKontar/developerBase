package com.app;

import com.app.DAO.DAODeveloper;
import com.app.DAO.JdbcDao.DAODeveloperImpl;
import com.app.Entities.Developer;

/**
 * Created by User on 04.06.2017.
 */
public class Main {
    public static void main(String[] args) {

        DAODeveloper daoDeveloper = new DAODeveloperImpl();

        Developer developer = new Developer("Andrey", "Minov");
        Developer developer1 = new Developer("Artur", "Roze");

//        daoDeveloper.create(developer1);
        System.out.println(daoDeveloper.read(2));

    }
}
