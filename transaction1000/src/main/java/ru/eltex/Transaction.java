package ru.eltex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Transaction {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/USER?useSSL=false";

    public static void write1000(String table) {
        ArrayList<User> listDevSql = new ArrayList<User>();
        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, "root", "Pass123*123");     //соединение с БД
            Statement statement = connection.createStatement();
            long sysTime = System.currentTimeMillis();
            statement.executeUpdate("drop table if exists " + table + ";");
            System.out.println("Время удаления таблицы в мс" + (System.currentTimeMillis() - sysTime));
            sysTime = System.currentTimeMillis();
            statement.executeUpdate("create table if not Exists " + table +
                    "(id INTEGER(11), fio Varchar(50), phone varchar(12))"+";");

            for (Integer i = 1; i < 1000; i++) {
                User user = new User(i, i.toString() + i.toString(), i.toString() + "phone", i.toString());
                statement.executeUpdate("INSERT INTO " + table + " VALUES(" +
                        user.getId() + ",\"" + user.getFio() + "\"," +
                        "\"" + user.getPhone() + "\");");
            }
            System.out.println("Время добавления 1000 users без транзакции в мс:" + (System.currentTimeMillis() - sysTime));

            connection.close(); // отключение от БД
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void write1000Transaction(String table) {
        ArrayList<User> listDevSql = new ArrayList<User>();
        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, "root", "Pass123*123");     //соединение с БД
            Statement statement = connection.createStatement();
            long sysTime = System.currentTimeMillis();
            connection.setAutoCommit(false);
            sysTime = System.currentTimeMillis();
            statement.executeUpdate("drop table if exists " + table + ";");
            System.out.println("Время удаления таблицы в мс: " + (System.currentTimeMillis() - sysTime));
            sysTime = System.currentTimeMillis();
            statement.executeUpdate("create table if not Exists " + table +
                    "(id INTEGER(11), fio Varchar(50), phone varchar(12))"+";");

            for (Integer i = 1; i < 1000; i++) {
                User user = new User(i, i.toString() + i.toString(), i.toString() + "phone", i.toString());
                statement.executeUpdate("INSERT INTO " + table + " VALUES(" +
                        user.getId() + ",\"" + user.getFio() + "\"," +
                        "\"" + user.getPhone() + "\");");
            }
            connection.commit();
            System.out.println("Время добавления 1000 users c транзакцией в мс:" + (System.currentTimeMillis() - sysTime));

            connection.close(); // отключение от БД
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}