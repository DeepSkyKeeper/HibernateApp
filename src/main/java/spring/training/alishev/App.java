package spring.training.alishev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spring.training.alishev.model.Person;

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
           Person person = session.find(Person.class, 1);
           System.out.println(person.getName());
           System.out.println(person.getAge());
           session.getTransaction().commit();
       }
       finally{
        sessionFactory.close();
        }
    }
}
