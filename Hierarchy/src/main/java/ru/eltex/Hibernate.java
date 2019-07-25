package ru.eltex;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

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
        Manager user1 =new Manager(888,"24234","23423","234234");

        Manager user2 =new Manager(999,"24234","3333","444444");
// создание сессии (запись в БД)
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user1); session.save(user2);
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
