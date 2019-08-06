package ru.eltex;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class SQL {


    public static void printUserFromSql(String table) throws SQLException, IOException {
        FileInputStream fis;
        Properties pr = new Properties();
        fis = new FileInputStream("src/main/resources/db.properties");
        try {
            pr.load(fis);
            String DB_URL = pr.getProperty("db.host");

            Connection connection = DriverManager.getConnection(DB_URL,
                    pr.getProperty("db.user"), pr.getProperty("db.password")); //connect with MYSQL
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + table); // get data from SQL
            while (resultSet.next()) { // проход по полученным записям
                String id = resultSet.getString("id"); // получение значений полей
                String fio = resultSet.getString("fio"); // получение значений полей
                String phone = resultSet.getString("phone"); // получение значений полей
                System.out.println(id + " " + fio + " " + phone);
            }

            connection.close(); // отключение от БД
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());

        }
    }


    public static void writeUserFromCsvToSqlTable(String dir, String table) {
// Read "table" from SQL. Read file location "dir".
// If have not this ID in SQL table ->write Develop to SQL table

//read SQL TABLE
        ArrayList<Developer> listDevSql = new ArrayList<Developer>();
        try {
            FileInputStream fis;
            Properties pr = new Properties();
            fis = new FileInputStream("src/main/resources/db.properties");
            pr.load(fis);
            String DB_URL = pr.getProperty("db.host");
            Connection connection = DriverManager.getConnection(
                    DB_URL, pr.getProperty("db.user"), pr.getProperty("db.password")); //connect with MYSQL
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + table + ";"); // получение записей
            while (resultSet.next()) {      // проход по полученным записям
                Developer dev = new Developer();
                dev.setId(Integer.parseInt(resultSet.getString("id")));
                dev.setFio(resultSet.getString("fio"));
                dev.setPhone(resultSet.getString("phone"));
                listDevSql.add(dev);         //Create Collection from SQL table
            }
//read file
            try {
                FileReader fr = new FileReader(dir);
                Scanner in = new Scanner(fr);
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    Developer developer = new Developer();
                    developer.fromCSV(line);    // fill data from line to developer
                    boolean dodo = true;
                    for (Developer d : listDevSql) {   //compare ID. If same ->not to do copy
                        if (developer.getId().equals(d.getId())) {
                            dodo = false;
                            System.out.println("User with ID: " + developer.getId() + " already exist");
                        }
                    }
// Write to SQL table if does noe exist
                    if (dodo) {
                        System.out.println("Write User with ID:" + developer.getId() + " in SQL table");
                        statement.executeUpdate("INSERT INTO " + table + " VALUES(" +
                                developer.getId() + ",\"" + developer.getFio() + "\"," +
                                "\"" + developer.getPhone() + "\");");
                    }
                }
            } catch (IOException error) {
                System.err.print(error.getMessage());
            }
            connection.close(); // отключение от БД
        } catch (SQLException | FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
