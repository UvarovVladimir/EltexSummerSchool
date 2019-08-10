package ru.eltex;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.eltex.entity.User;
import sun.security.ssl.HandshakeInStream;

import java.util.ArrayList;
import java.util.List;

//        JSONObject object = new JSONObject();
//        object.put("name", "Vlad");
//        object.put("phone", "234");
//        JSONObject object2 = new JSONObject();
//        object2.put("name", "Denis");
//        object2.put("phone", "345");
//        JSONArray arra = new JSONArray();
//        arra.put(object);arra.put(object2);
//        JSONObject object3333 = new JSONObject();
//        object3333.put("masss",arra);


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


