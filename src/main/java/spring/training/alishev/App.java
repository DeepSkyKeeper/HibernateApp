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
//          addPersons(session);
//           updatePersons(session);
//            deletePersons(session);
            Person person = new Person("Lena",33);
            session.persist(person);
            session.getTransaction().commit();
            System.out.println(person.getId());//получить id из БД после добавления
        } finally {
            sessionFactory.close();
        }
    }

    public static void addPersons(Session session) {
        Person person1 = new Person("Test1", 34);
        Person person2 = new Person("Test2", 28);
        Person person3 = new Person("Test3", 30);
        session.persist(person1);
        session.persist(person2);
        session.persist(person3);

    }

    public static void updatePersons(Session session) {
        Person person = session.getReference(Person.class, 4);
        person.setName("NastyaKvitko");
        person.setAge(31);
    }

    public static void deletePersons(Session session) {
        Person person = session.getReference(Person.class, 5);
        session.remove(person);
    }
}
