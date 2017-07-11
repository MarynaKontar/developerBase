package com.app.Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by User on 05.07.2017.
 */
public class EMFactory {

    private  static EntityManagerFactory factory= Persistence
            .createEntityManagerFactory("unit1");


    private EMFactory() {
    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return factory;
    }
    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
}
