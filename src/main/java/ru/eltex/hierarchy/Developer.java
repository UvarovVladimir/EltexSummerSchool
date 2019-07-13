package ru.eltex.hierarchy;

import java.util.ArrayList;

class Developer extends User implements CSV{

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
        ArrayList<String> listLang = new ArrayList<>();   // For Parce elements  of arrTmp for Sale array
        for (int i = 4;i<arr.length;i++ ) {
            listLang.add(arr[i]);
        }
        this.listLang=listLang; // Add collection to developers object
    }

    //variables
    ArrayList<String> listLang ;
    //constructor
    public Developer(Integer id, String fio, String phone, String email){
        super( id,  fio,  phone,  email);
    }
    public Developer(){};
    //get set
    public void setListLang(ArrayList<String> listLang){ this.listLang = listLang;}
    public ArrayList<String> getListLang(){return this.listLang;}

}