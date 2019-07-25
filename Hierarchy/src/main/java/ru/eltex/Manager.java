package ru.eltex;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.Entity;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
@Entity
class Manager extends User implements CSV,JSON {
//Interface
    @Override
    public  String toCSV(){
        String saleLine = "";
        for (Sale sale:this.listSale){
            saleLine+=","+sale.name+":"+sale.cost;
        }
        return super.getId() +","+super.getFio() +"," +super.getPhone() +
                "," + super.getEmail() + saleLine;
    }
    @Override
    public void fromCSV(String str){
        String[] arr = str.split(",");  //Parse Line
        if(arr.length>=4) {
            super.setId(Integer.parseInt(arr[0]));
            super.setFio(arr[1]);
            super.setPhone(arr[2]);
            super.setEmail(arr[3]);
        }
        if (arr.length>=5) {
            ArrayList<Sale> listSale = new ArrayList<Sale>();   //Create list for objects Sale
            for (int i = 4; i < arr.length; i++) {
                Sale sale = new Sale();
                sale.fromCSV(arr[i]);// For Parce  String elements  to object sale(name, cost)
                listSale.add(sale);
            }
            this.listSale = listSale; // Add collection to manegers object
        }
    }
    @Override
    public  String toJson(){
        ObjectMapper mapper = new ObjectMapper();
        String managerJSON ="";
        File file = new File("src/main/resources/Managers.json");
        try {
            mapper.writeValue(file, this);
            managerJSON = mapper.writeValueAsString(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  managerJSON;
    }

    @Override
    public  void fromJson(String dir) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        Manager manager = mapper.readValue(new File(dir), Manager.class);
        this.setId(manager.getId());
        this.setFio(manager.getFio());
        this.setPhone(manager.getPhone());
        this.setEmail(manager.getEmail());
        this.setListSale(manager.getListSale());
    }


//variables
    ArrayList<Sale> listSale ;
    //constructor
    public Manager(Integer id, String fio, String phone, String email){
        super( id,  fio,  phone,  email);
    }
    public Manager(){};
    //get set
    public void setListSale(ArrayList<Sale> listSale){ this.listSale = listSale;}
    public ArrayList<Sale> getListSale(){return this.listSale;}

}
