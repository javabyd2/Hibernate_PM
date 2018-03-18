package com.pm.sda.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {

    private static final SessionFactory sessionFactory;

    static{
        try{
            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        }catch(Throwable ex){
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException{
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {

    }
}
