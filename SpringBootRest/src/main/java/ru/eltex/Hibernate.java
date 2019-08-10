package ru.eltex;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.eltex.entity.User;

import java.util.ArrayList;
import java.util.List;


public class Hibernate {
    private static SessionFactory sessionFactory;

    public static User getUserData(Integer id) throws JsonProcessingException {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw e;
        }
        // создание сессии (чтения из БД)
        Session sessionR = sessionFactory.openSession();
        sessionR.beginTransaction();
        User user = sessionR.get(User.class, id); // получение по ключевому полю
        sessionR.getTransaction().commit();
        sessionR.close();
        if (user == null) return new User("noname", "0");
        return user;
    }

    public static List<User> getAllUserData() throws JsonProcessingException {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw e;
        }
        // создание сессии (чтения из БД)
        Session sessionR = sessionFactory.openSession();
        sessionR.beginTransaction();
        List<User> users = sessionR.createQuery("from User").list();
        sessionR.getTransaction().commit();
        sessionR.close();
//        if (users.size() == 0) {
//            List<User> noname = new ArrayList<>();
//            noname.add(new User("noname", "0"));
//            return
//        }
        for (User u : users) {
            System.out.println(u.toString());
        }
        return users;
    }

    public static String removeUser(Integer id) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw e;
        }
        // создание сессии (удаления из БД)
        Session sessionD = sessionFactory.openSession();
        sessionD.beginTransaction();
        User user = sessionD.get(User.class, id); // получение по ключевому полю
        if (user == null) {
            sessionD.getTransaction().commit();
            sessionD.close();
            return "We cant find user with id: " + id + " !!!";
        }
        sessionD.delete(user);
        sessionD.getTransaction().commit();
        sessionD.close();
        return "Deleting user with id: " + id + " has done";
    }

    public static void createUsers() {
        // создание сервиса взаимодействия
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw e;
        }
        User user1 = new User("Vladimir1", "24234234");
        User user2 = new User("Denis2", "234234234");
        User user3 = new User("Mike3", "33355444");
        User user4 = new User("Denis27", "9995588844");
        User user5 = new User("Denis255", "44554433322334");
// создание сессии (запись в БД)
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user1);
        session.save(user2);
        session.save(user3);
        session.save(user4);
        session.save(user5);
        session.getTransaction().commit();
        session.close();
    }
}
