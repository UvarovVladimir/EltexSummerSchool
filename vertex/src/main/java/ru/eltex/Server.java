package ru.eltex;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import jdk.nashorn.internal.runtime.JSONListAdapter;
import ru.eltex.entity.User;

public class Server {
//    public static void VertexServer(){
//
//        System.out.println("Vertex Start");
//        User user1 = new User("Boris","900990990");
//        User user2 = new User("Aleks","888888");
//        User user3 = new User("Denis","9966655");
//        User user4 = new User("Nic","44443333");
//
//
//        Vertx vertx = Vertx.vertx(new VertxOptions().setWorkerPoolSize(40)); // количество обработчиков
//        vertx.createHttpServer().requestHandler(request -> {
//            System.out.println(request.uri()); // что было вызвано
//
//            switch (request.uri()){
//                case "/get_users":
//                    request.response()
//                            .putHeader("Content-Type", "application/json")
//                            .end("{\"text\":\"Hello\"}"); // завершение и отправка данных
//
//            }
//            switch (request.uri()){
//                case "/create":
//                    try {
//                        request.response()
//                                .putHeader("Content-Type", "application/json")
//                                .end("["+user1.toJson()+","+user2.toJson()+"]"); // завершение и отправка данных
//                    } catch (JsonProcessingException e) {
//                        e.printStackTrace();
//                    }
//
//            }
//
//        /*    JsonArray arra = new JsonArray();
////            arra.
//            JsonObject object = new JsonObject();
//            object.put("user", arra);
////            object.getJsonArray()
////            object.put("phone", "900");
//*/
//
//        }).listen(8081);
//
//
//
//    }
}
