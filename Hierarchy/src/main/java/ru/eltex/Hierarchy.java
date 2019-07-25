package ru.eltex;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hierarchy {
    public static void main(String[] args) {
        //***MANAGERS***
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
        System.out.println("    *** Managers Data ***");
        for (Manager manager:listManag){
            System.out.println(manager.toCSV());
        }

        //***Developers***
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
        System.out.println("    *** Developers Data ***");
        for (Developer developer:listDevelop){
            System.out.println(developer.toCSV());
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
        System.out.println("     ***Compare Developer №3 ID with Managers ID *** " );
        for (Manager manager:listManag){
            System.out.println(listDevelop.get(2).compareIdTo(manager));//Compare Id Developer№2 with managers Id

        }

        //*************************Equals*************************
        System.out.println("     ***Compare Developer №3 ID with Managers ID *** " );
        for (Manager manager:listManag){
            System.out.println(listDevelop.get(2).equalsFioTo(manager));
        }
//SQL
        System.out.println("    *** SQL***");
        SQL.writeUserFromCsvToSqlTable("src/main/resources/Managers.csv", "DEVELOPER");
        SQL.printUserFromSql("DEVELOPER");
//Json
        for(Manager manager:listManag){
            System.out.println(manager.toJson());
        }

        Manager manFromJson =new Manager();
        try {
            manFromJson.fromJson("src/main/resources/Managers.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(manFromJson.toCSV());


        for(Developer developer:listDevelop){
            System.out.println(developer.toJson());
        }
        Developer devFromJson =new Developer();
        try {
            devFromJson.fromJson("src/main/resources/Developers.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(devFromJson.toCSV());

    //Hibernate
        Hibernate.hibernate();
    }
}

