package org.example;

import org.example.model.Item;
import org.example.model.Passport;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {

            session.beginTransaction();

            //Person person2 = session.get(Person.class, 3);
            //person2.setPassport(new Passport(54678));
            System.out.println(session.get(Passport.class, 2));

//            Person person = session.get(Person.class, 11);
//            System.out.println(person.getPassport().getPassportNumber());

//            Passport passport = session.get(Passport.class, 11);
//            System.out.println(passport.getPerson().getName());

            Person person1 = session.get(Person.class, 1);
            person1.getPassport().setPassportNumber(566);
            System.out.println(person1.getPassport().getPassportNumber());

         //   session.remove(person);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
