package ru.eltex;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReadWrite {
    public static ArrayList<Manager> readManagers() {
        //Fill data of MANAGERS from file
        System.out.println("*Fill data of Managers from file*");
        ArrayList<Manager> listManag = new ArrayList<Manager>();
        try {
            FileReader fr = new FileReader("src/main/resources/Managers.csv");
            Scanner in = new Scanner(fr);
            while (in.hasNextLine()) {                       //read lines until the end
                String line = in.nextLine();
                Manager manager = new Manager();
                manager.fromCSV(line);                       //Fill Data to object manager
                listManag.add(manager);
            }
        } catch (
                IOException error) {
            System.err.print(error.getMessage());
        }
        return listManag;
    }

    public static void printManagers(ArrayList<Manager> listManag) {
        // Print data from Class
        System.out.println("    *Print Managers Data *");
        for (Manager manager : listManag) System.out.println(manager.toCSV());
    }

    public static ArrayList<Developer> readDevelopers() {
        //Fill data of MANAGERS from file

        System.out.println("*Fill data of Developers from file*");
        ArrayList<Developer> listDevelop = new ArrayList<Developer>();
        try {
            FileReader fr = new FileReader("src/main/resources/Developers.csv");
            Scanner in = new Scanner(fr);
            while (in.hasNextLine()) {                           //read lines until the end
                String line = in.nextLine();
                Developer developer = new Developer();
                developer.fromCSV(line);
                listDevelop.add(developer);
            }
        } catch (IOException error) {
            System.err.print(error.getMessage());
        }
        return listDevelop;
    }

    public static void printDevelopers(ArrayList<Developer> listDevelop) {
        // Print data from Class
        System.out.println("    *Print Developers Data *");
        for (Developer developer : listDevelop) System.out.println(developer.toCSV());
    }

    public static void writeManagers(ArrayList<Manager> listManag) {
        try {
            FileWriter fw = new FileWriter("src/main/resources/ManagersW.csv", true);
            fw.write(listManag.get(2).toCSV() + "\n");
            fw.flush();
            fw.close();
        } catch (IOException error) {
            System.err.print(error.getMessage());
        }
    }

}
