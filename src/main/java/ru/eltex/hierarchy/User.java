package ru.eltex.hierarchy;

abstract class User {


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

    public User(){}


}
