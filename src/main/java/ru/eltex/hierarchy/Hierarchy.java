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
abstract class User implements CSV {

    //Interface
    public  String toCSV(){
        return this.id +";"+this.fio +";" +this.phone + ";" + this.email;
    }
    public void fromCSV(String str){
        String[] arr = str.split(";");
    }

    //Variable
    private Integer id;
    private String fio;
    private String phone;
    private String email;
    // Get Set
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) { this.id = id; }

    public String getFio() {
        return fio;
    }
    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        this.email = email;
    }

    //Constructor
    public User(Integer id, String fio, String phone, String email){
        this.id=id;
        this.fio=fio;
        this.phone=phone;
        this.email=email;
    }
}


class Manager extends User{
   // super.setFio(fio);       ?????????????????

    public Manager(Integer id, String fio, String phone, String email){
        super( id,  fio,  phone,  email);
    }
    ArrayList<Sale> listSale = new ArrayList<>() ;
}


class Developer extends User{
    public Developer(Integer id, String fio, String phone, String email){
        super(id,  fio,  phone,  email);
    }
    ArrayList<String> listLang = new ArrayList<>() ;
}


public class Hierarchy {
    public static void main(String[] args) {
        ArrayList<Manager> listManag = new ArrayList<Manager>();


        try{
            FileReader fr = new FileReader("src/main/resources/Managers.csv");
            Scanner in =new Scanner(fr);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                ArrayList<String> listManagParse = new ArrayList<String>();
                ArrayList<String> listSale = new ArrayList<String>();
                String[] arr = line.split(",");
                for (int i =0; i<arr.length; i++){
                    listManagParse.add(arr[i]);
                    if (i>3) {
                        arr[i].split("цена:");
                    }
                }
                Manager manager = new Manager(Integer.parseInt(listManagParse.get(0)) , listManagParse.get(1), listManagParse.get(2), listManagParse.get(3));
               // System.out.println(line); //печать строки в стандартный вывод
                listManag.add(manager);

            }

        } catch (IOException error){
            System.err.print(error.getMessage());
        }

        // Print data from Class
        for (int i =0; i<listManag.size();i++){
            System.out.println(listManag.get(i).toCSV());
        }








/*
        try{
            FileWriter fw = new FileWriter("src/main/resources/ManagersW.csv", true);

            fw.write(Dev1.toCSV()+"\n");
            fw.flush();
            fw.close();
        } catch (IOException error){
            System.err.print(error.getMessage());
        }

 */
    }
}
