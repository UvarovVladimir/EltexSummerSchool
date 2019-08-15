package ru.eltex.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public interface Json {
    String toJson() throws JsonProcessingException;

    void fromJson(String dir) throws IOException;
}

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
