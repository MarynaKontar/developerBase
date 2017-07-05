package com.app.Utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by User on 05.07.2017.
 */
public class SessionFactoryDB {
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    private SessionFactoryDB() {
    }

    public static Session getSession(){
        return sessionFactory.openSession();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
