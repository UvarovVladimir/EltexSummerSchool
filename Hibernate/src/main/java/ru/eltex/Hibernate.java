package ru.eltex;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.eltex.entity.Passport;
import ru.eltex.entity.User;


public class Hibernate {

    private static SessionFactory sessionFactory  ;
    public static void hibernate(){
        // создание сервиса взаимодействия
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw e;
        }
        User user1 =new User("Vladimir");
        User user2 =new User("Denis");
        User user3 =new User("Mike");

        Passport passport1 =new Passport ("3208576688L");
        Passport passport2 =new Passport ("5466778899L");
        Passport passport3 =new Passport ("6723998877");
        user1.setPassport(passport1);
        user2.setPassport(passport2);
        user3.setPassport(passport3);

// создание сессии (запись в БД)
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user1); session.save(user2);session.save(user3);
        session.save(passport1); session.save(passport2);session.save(passport3);

        session.getTransaction().commit();
        session.close();

/*

        //  HQL
        session.beginTransaction();
        List<User> users = session.createQuery("from User").list();
        users.forEach(u -> System.out.println(String.format("%s, %s!",
        u.getFio(),
        u.getPhone())));
        session.getTransaction().commit();
        session.close();
*/


    }

}
