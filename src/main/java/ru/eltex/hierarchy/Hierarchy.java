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
    //variables
    ArrayList<Sales> listSale ;
    //constructor
    public Manager(Integer id, String fio, String phone, String email){
        super( id,  fio,  phone,  email);
    }
    //get set
    public void setListSale(ArrayList<Sales> listSale){ this.listSale = listSale;}
    public ArrayList<Sales> getListSale(){return this.listSale;}

    @Override
    public Integer getId() {
        return super.getId();
    }
    @Override
    public String getFio() {
        return super.getFio();
    }
    @Override
    public String getPhone() {
        return super.getPhone();
    }
    @Override
    public String getEmail() {
        return super.getEmail();
    }
    @Override
    public void setId(Integer id) {
        super.setId(id);
    }
    @Override
    public void setFio(String fio) {
        super.setFio(fio);
    }
    @Override
    public void setPhone(String phone) {
        super.setPhone(phone);
    }
    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }
}

class Developer extends User{

    //variables
    ArrayList<String> listLang ;
    //constructor
    public Developer(Integer id, String fio, String phone, String email){
        super( id,  fio,  phone,  email);
    }
    //get set
    public void setListLang(ArrayList<String> listLang){ this.listLang = listLang;}
    public ArrayList<String> getListLang(){return this.listLang;}

    @Override
    public Integer getId() {
        return super.getId();
    }
    @Override
    public String getFio() {
        return super.getFio();
    }
    @Override
    public String getPhone() {
        return super.getPhone();
    }
    @Override
    public String getEmail() {
        return super.getEmail();
    }
    @Override
    public void setId(Integer id) {
        super.setId(id);
    }
    @Override
    public void setFio(String fio) {
        super.setFio(fio);
    }
    @Override
    public void setPhone(String phone) {
        super.setPhone(phone);
    }
    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }
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
