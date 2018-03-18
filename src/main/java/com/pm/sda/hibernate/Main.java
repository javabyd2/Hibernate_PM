package com.pm.sda.hibernate;

import com.pm.sda.hibernate.entity.BookEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
        BookEntity bookEntity = new BookEntity();
        bookEntity.setAuthor("Jan Kowalski");
        bookEntity.setTitle("Programowanie dla dzieci");

        Transaction tx = null;
        Session session = getSession();

        tx = session.beginTransaction();
        session.save(bookEntity);
        tx.commit();

    }
}
