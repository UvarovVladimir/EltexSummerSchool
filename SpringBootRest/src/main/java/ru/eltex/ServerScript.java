package ru.eltex;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.eltex.entity.User;
import java.util.List;

@RestController
public class ServerScript {

    @RequestMapping("/get_users")
    public List<User> getUsers() throws JsonProcessingException {
        System.out.println("***Show all users:");
        return Hibernate.getAllUserData();
    }

    @RequestMapping("/get_user/{id}")
    public User getUser(@PathVariable("id") Integer id) throws JsonProcessingException {
        System.out.println("*** Show  user " + id+":");
        return Hibernate.getUserData(id);
    }

    @RequestMapping("/remove_user/{id}")
    public String removeUser(@PathVariable("id") Integer id) throws JsonProcessingException {
        System.out.println("*** Remove  user " + id+":");
        return Hibernate.removeUser(id);
    }

    @RequestMapping("/create")
    public String create() throws JsonProcessingException {
        System.out.println("*** Create  users");
        Hibernate.createUsers();
        return "Users has been created";
    }
}


