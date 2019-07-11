package ru.eltex.hierarchy;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

interface CSV {
    String toCSV();
    void fromCSV(String str);
}

public class Hierarchy {
    public static void main(String[] args) {
        //************************MANAGERS*************************
        ArrayList<Manager> listManag = new ArrayList<Manager>();
        try{
            FileReader fr = new FileReader("src/main/resources/Managers.csv");
            Scanner in =new Scanner(fr);
            while (in.hasNextLine()) {                                 //read lines until the end
                String line = in.nextLine();
                String[] arrTmp = line.split(",");              //Create new arr from line String
                Manager manager = new Manager(Integer.parseInt(arrTmp[0]) , arrTmp[1], arrTmp[2], arrTmp[3]);
                listManag.add(manager);

                ArrayList<Sales> listSale = new ArrayList<Sales>();    // For Parce elements  of arrTmp for Sale array
                for (int i=4; i<arrTmp.length;i++){
                    String[] arrTmp2 = arrTmp[i].split(" цена:");
                    Sales sales = new Sales(arrTmp2[0] ,Double.parseDouble(arrTmp2[1])); // Double.parseDouble(arrTmp2[0]
                    listSale.add(sales);
                }
                manager.setListSale(listSale);// Add collection to manegers object
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
                String[] arrTmp = line.split(",");              //Create new arr from line String
                Developer developer = new Developer(Integer.parseInt(arrTmp[0]) , arrTmp[1], arrTmp[2], arrTmp[3]);
                listDevelop.add(developer);

                ArrayList<String> listLang = new ArrayList<String>();    // For Parce elements  of arrTmp for Sale array
                for (int i=4; i<arrTmp.length;i++){
                        listLang.add(arrTmp[i]);
                }
                developer.setListLang(listLang);// Add collection to developers object
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
