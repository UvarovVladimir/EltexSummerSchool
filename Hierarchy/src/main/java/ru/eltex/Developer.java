package ru.eltex;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.eltex.interfaces.CSV;
import ru.eltex.interfaces.JSON;

import javax.persistence.Entity;
import java.io.IOException;
import java.util.ArrayList;
@Entity
class Developer extends User implements CSV, JSON {
//Interface
    @Override
    public  String toCSV(){
        String lang ="";
        for (String s:this.listLang){
            lang+="," + s;
        }
        return super.getId() +","+super.getFio() +","
                +super.getPhone() + "," + super.getEmail()+lang;
    }
    @Override
    public void fromCSV(String str){
        String[] arr = str.split(",");            //Parse Line
        if (arr.length>=4) {
            super.setId(Integer.parseInt(arr[0]));
            super.setFio(arr[1]);
            super.setPhone(arr[2]);
            super.setEmail(arr[3]);
        }
        if (arr.length>=5) {
            ArrayList<String> listLang = new ArrayList<>();   // For Parce elements  of arrTmp for Sale array
            for (int i = 4; i < arr.length; i++) {
                listLang.add(arr[i]);
            }
            this.listLang = listLang;            // Add collection to developers object
        }
    }

    @Override
    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String developerJSON =  mapper.writeValueAsString(this);
        return developerJSON;
    }

    @Override
    public void fromJson(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Developer developer = mapper.readValue(json, Developer.class);
        this.setId(developer.getId());
        this.setFio(developer.getFio());
        this.setPhone(developer.getPhone());
        this.setEmail(developer.getEmail());
        this.setListLang(developer.getListLang());

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