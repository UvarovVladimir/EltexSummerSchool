package ru.eltex;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class JsonReadWrite {
    public static void writeManagers(ArrayList<Manager> listManag) throws JsonProcessingException {
        System.out.println("*Write data of Managers from Json!*");
        for (Manager manager : listManag) {
            System.out.println(manager.toJson());
        }
    }

    public static ArrayList<Manager> fillManagers() {
        System.out.println("*Fill data of Managers from Json file! *");
        ArrayList<Manager> listManag = new ArrayList<Manager>();
        try {
            FileReader fr = new FileReader("src/main/resources/Managers.json");
            Scanner in = new Scanner(fr);
            while (in.hasNextLine()) {                       //read lines until the end
                String line = in.nextLine();
                Manager manager = new Manager();
                manager.fromJson(line);                       //Fill Data to object manager
                listManag.add(manager);
            }
        } catch (
                IOException error) {
            System.err.print(error.getMessage());
        }
        return listManag;


    }


    public static void writeDevelopers(ArrayList<Developer> listManag) throws JsonProcessingException {
        System.out.println("*Write data of Developers from Json!*");
        for (Developer developer : listManag) {
            System.out.println(developer.toJson());
        }
    }

    public static ArrayList<Developer> fillDevelopers() {
        System.out.println("*Fill data of Developers from Json file! *");
        ArrayList<Developer> listDevelop = new ArrayList<Developer>();
        try {
            FileReader fr = new FileReader("src/main/resources/Developers.json");
            Scanner in = new Scanner(fr);
            while (in.hasNextLine()) {                       //read lines until the end
                String line = in.nextLine();
                Developer developer = new Developer();
                developer.fromJson(line);                       //Fill Data to object manager
                listDevelop.add(developer);
            }
        } catch (
                IOException error) {
            System.err.print(error.getMessage());
        }
        return listDevelop;
    }
}
