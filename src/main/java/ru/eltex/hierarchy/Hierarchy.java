package ru.eltex.hierarchy;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
                manager.fromCSV(line);                             //Fill Data to object manager
                listManag.add(manager);
            }
        } catch (IOException error){
            System.err.print(error.getMessage());
        }

        // Print data from Class
        System.out.println("*** Managers Data ***");
        for (int i =0; i<listManag.size();i++){
            System.out.println(listManag.get(i).toCSV());
        }
        System.out.println("*** Sales Data ***");
        for (int i =0; i<listManag.size();i++){                                // Cycle choose managers
            System.out.println("   Manager №"+listManag.get(i).getId());
            for(int j=0; j<listManag.get(i).listSale.size();j++){               //Cycle print managers sale list
                System.out.println(listManag.get(i).listSale.get(j).getName() + ": " +
                        listManag.get(i).listSale.get(j).getCost());
            }
        }

        //***********************Developers********************************
        ArrayList<Developer> listDevelop = new ArrayList<Developer>();
        try{
            FileReader fr = new FileReader("src/main/resources/Developers.csv");
            Scanner in =new Scanner(fr);
            while (in.hasNextLine()) {                                 //read lines until the end
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
        for (int i =0; i<listDevelop.size();i++){
            System.out.println(listDevelop.get(i).toCSV());
        }
        System.out.println("*** Lang List ***");
        for (int i =0; i<listDevelop.size();i++){                                // Cycle choose managers
            System.out.println("   Developer №"+listDevelop.get(i).getId());
            for(int j=0; j<listDevelop.get(i).listLang.size();j++){               //Cycle print managers sale list
                System.out.println(listDevelop.get(i).listLang.get(j));
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


    }
}
