package ru.eltex;

import java.util.ArrayList;

class Manager extends User implements CSV {

    //Interface
    public  String toCSV(){
        return super.getId() +","+super.getFio() +"," +super.getPhone() + "," + super.getEmail();
    }
    public void fromCSV(String str){
        String[] arr = str.split(",");  //Parse Line
        super.setId(Integer.parseInt(arr[0]));
        super.setFio(arr[1]);
        super.setPhone(arr[2]);
        super.setEmail(arr[3]);
        ArrayList<Sale> listSale = new ArrayList<Sale>();   //Create list for objects Sale
        for (int i = 4;i<arr.length;i++ ) {
            Sale sale = new Sale();
            sale.fromCSV(arr[i]);// For Parce  String elements  to object sale(name, cost)
            listSale.add(sale);
        }
        this.listSale=listSale; // Add collection to manegers object

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
