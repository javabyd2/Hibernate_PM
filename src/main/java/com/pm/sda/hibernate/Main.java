package com.pm.sda.hibernate;

import com.pm.sda.hibernate.entity.BookEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.awt.print.Book;
import java.util.List;


public class Main {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setAuthor("Jacek Miedlar");
        bookEntity.setTitle("Moja walka");

        BookEntity bookEntity2 = new BookEntity();
        bookEntity2.setAuthor("Lukasz Zimmerman");
        bookEntity2.setTitle("Bogactwo i nedza narodow");

        Transaction tx = null;
        Session session = getSession();

        tx = session.beginTransaction();

        session.save(bookEntity);
        session.save(bookEntity2);

        tx.commit();

        tx = session.beginTransaction();
        List<BookEntity>bookEntityList = session.createCriteria(BookEntity.class).list();
        System.out.println(bookEntityList);

        List<BookEntity> bookEntityList1 = session.createQuery("FROM " + BookEntity.class.getName()).list();

        System.out.println("bookEntityList1 = " + bookEntityList1);

        for(BookEntity data: bookEntityList1){
            System.out.println("Autor: " + data.getAuthor());
            System.out.println("Tytul: " + data.getAuthor());
        }





    }
}
