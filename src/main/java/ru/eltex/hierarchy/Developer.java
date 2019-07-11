package ru.eltex.hierarchy;

import java.util.ArrayList;

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