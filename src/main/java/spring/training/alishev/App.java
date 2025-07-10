package spring.training.alishev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spring.training.alishev.model.Person;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration config = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
//         List<Person> people= session.createQuery("from Person where age>30").getResultList();
            List<Person> people= session.createQuery("from Person where name like 'T%'").getResultList();
        for (Person person : people) {
            System.out.println(person);
        }
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }

}
