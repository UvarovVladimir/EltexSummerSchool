package ru.eltex;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.*;

public class MongoDb {
    public static void mongoDbDo() {


        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/db.properties");
            property.load(fis);
//            String host = property.getProperty("db.host");
//            String login = property.getProperty("db.login");
//            String password = property.getProperty("db.password");
//            String table = property.getProperty("db.table");
//            System.out.println("HOST: " + host
//                    + ", LOGIN: " + login
//                    + ", PASSWORD: " + password);
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }


// присоединение
        MongoClient mongoClient = MongoClients.create(property.getProperty("db.host"));
        MongoDatabase db = mongoClient.getDatabase(property.getProperty("db.database"));
        MongoCollection<Document> table = db.getCollection(property.getProperty("db.table"));
// создание записи
        List<Document> listdoc = new ArrayList<>();
        Document doc1 = new Document("name", "Ivan")
                .append("phone", "900111")
                .append("lang", Arrays.asList("java", "c++"));
        listdoc.add(doc1);

        Document doc2 = new Document("name", "Dmitry")
                .append("phone", "900222")
                .append("lang", Arrays.asList("java"));
        listdoc.add(doc2);
        Document doc3 = new Document("name", "Georgy")
                .append("phone", "900333")
                .append("lang", Arrays.asList("java", "Delphy", "c++"));
        listdoc.add(doc3);
        Document doc4 = new Document("name", "Neo")
                .append("phone", "900444")
                .append("lang", Arrays.asList("java", "c++","Delphy","Pyton"));
        listdoc.add(doc4);
        Document doc5 = new Document("name", "Simon")
                .append("phone", "900555")
                .append("lang", Arrays.asList( "c++"));
        listdoc.add(doc5);
//        table.insertOne(doc); // table.insertMany(userList);
        table.insertMany(listdoc);
//        Document myDoc = table.find().first();
//        System.out.println(myDoc.toJson());
        for (Document cur : table.find()) {
            System.out.println(cur.toJson());
        }
    }
}
