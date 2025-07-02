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
           Person person1 = new Person("Test1",34);
           Person person2 = new Person("Test2",28);
           Person person3 = new Person("Test3",30);
          session.persist(person1);
          session.persist(person2);
          session.persist(person3);
           session.getTransaction().commit();
       }
       finally{
        sessionFactory.close();
        }
    }
}
