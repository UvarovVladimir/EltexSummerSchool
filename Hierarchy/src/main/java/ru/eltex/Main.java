package ru.eltex;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//***Managers*** Fill from file and print
        ArrayList<Manager> listManag = FileReadWrite.readManagers();
        FileReadWrite.printManagers(listManag);

//***Developers***  Fill from file and print
        ArrayList<Developer> listDevelop = FileReadWrite.readDevelopers();
        FileReadWrite.printDevelopers(listDevelop);
//***WRITE FILE***
        FileReadWrite.writeManagers(listManag);
//***COMPARE***
        Compare.compareId(listDevelop.get(2), listManag);
//***Equals***
        Compare.equalsFioTo(listDevelop.get(2), listManag);
//***SQL***
        System.out.println("    *** SQL***");
        try {
            SQL.writeUserFromCsvToSqlTable("src/main/resources/Managers.csv", "DEVELOPER");
            SQL.printUserFromSql("DEVELOPER");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
//***Json***
        try {
            listManag = JsonReadWrite.fillManagers();
            JsonReadWrite.writeManagers(listManag);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            listDevelop = JsonReadWrite.fillDevelopers();
            JsonReadWrite.writeDevelopers(listDevelop);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
//Hibernate
        System.out.println("hibern");
        //Hibernate.hibernate();
    }
}

