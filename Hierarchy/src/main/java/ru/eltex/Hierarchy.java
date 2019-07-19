package ru.eltex;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Hierarchy {
    public static void main(String[] args) {
        //************************MANAGERS*************************
        ArrayList<Manager> listManag = new ArrayList<Manager>();
        try{
            FileReader fr = new FileReader("src/main/resources/Managers.csv");
            Scanner in =new Scanner(fr);
            while (in.hasNextLine()) {                                 //read lines until the end
                String line = in.nextLine();
                Manager manager = new Manager();
                manager.fromCSV(line);                                 //Fill Data to object manager
                listManag.add(manager);
            }
        } catch (IOException error){
            System.err.print(error.getMessage());
        }

        // Print data from Class
        System.out.println("*** Managers Data ***");
        for (Manager manager:listManag){
            System.out.println(manager.toCSV());
        }
        System.out.println("*** Sales Data ***");
        for (Manager manager:listManag){                         // Cycle choose managers
            System.out.println("   Manager №"+manager.getId());
            for(Sale sale:manager.getListSale()){               //Cycle print managers sale list
                System.out.println(sale.toCSV());
            }
        }

        //***********************Developers********************************
        ArrayList<Developer> listDevelop = new ArrayList<Developer>();
        try{
            FileReader fr = new FileReader("src/main/resources/Developers.csv");
            Scanner in =new Scanner(fr);
            while (in.hasNextLine()) {                           //read lines until the end
                String line = in.nextLine();
                Developer developer = new Developer();
                developer.fromCSV(line);
                listDevelop.add(developer);
            }

        } catch (IOException error){
            System.err.print(error.getMessage());
        }

        // Print data from Class Developer
        System.out.println("*** Developers Data ***");
        for (Developer developer:listDevelop){
            System.out.println(developer.toCSV());
        }

        System.out.println("*** Lang List ***");
        for (Developer developer:listDevelop){                       // Cycle choose managers
            System.out.println("   Developer №"+developer.getId());
            for(String lang:developer.getListLang()){               //Cycle print managers sale list
                System.out.println(lang);
            }
        }

        //*************************WRITE*************************

        try{
            FileWriter fw = new FileWriter("src/main/resources/ManagersW.csv", true);

            fw.write(listManag.get(2).toCSV()+"\n");

            fw.flush();
            fw.close();
        } catch (IOException error){
            System.err.print(error.getMessage());
        }

        //*************************COMPARE*************************

        System.out.println("Compare Developer №2 ID with Managers ID  " );
        for (Manager manager:listManag){
           int i= listDevelop.get(2).compareTo(manager);//Compare Id Developer№2 with managers Id
            switch (i) {                 //Выбор операции
                case -1:
                    System.out.println("Manager " + manager.getFio()+ " Id more then yours!");
                    break;
                case 1:
                    System.out.println("Manager " + manager.getFio()+ " Id Less then yours!");
                    break;
                case 0:
                    System.out.println("Manager " + manager.getFio() +" Id equals");
                    break;
                default:
                    System.out.println("Wrong operation!");
            }
        }

        //*************************Equals*************************
        System.out.println("Compare Developer №2 ID with Managers ID  " );
        for (Manager manager:listManag){
            boolean  b = listDevelop.get(2).getFio().equals(
                    manager.getFio());
                    if (b) System.out.println("FIO equals!");
                    else  System.out.println("FIO Not equals");
        }


//SQL
        SQL.writeUserFromCsvToSqlTable("src/main/resources/Managers.csv", "DEVELOPER");
        SQL.printUserFromSql("DEVELOPER");

    }
}
