package ru.eltex;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println("Ready!!!!!!!");
//        try {
//            Hibernate.getAllUserData();
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }


    }
}
