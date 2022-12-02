package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {

            session.beginTransaction();

            Person person1 = new Person("Ram", 30);
            Person person2 = new Person("Sergey", 30);
            Person person3 = new Person("Rustem", 28);

            session.save(person1);
            session.save(person2);
            session.save(person3);

            Person person = session.get(Person.class, 1);
            System.out.println("Имя: " + person.getName() + ", возвраст: " + person.getAge());

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }


    }
}
