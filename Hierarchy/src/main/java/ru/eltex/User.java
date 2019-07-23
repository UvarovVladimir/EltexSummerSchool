package ru.eltex;

abstract class User implements Comparable {
    // Comparable
    public String compareIdTo(User other){
    //Compare ID of other user and this user .Return String.
        int i = this.id.compareTo(other.id);
        switch (i) {
            case -1:
                return  other.getFio()+ " Id more then Id "+ this.getFio();
            case 1:
                return  other.getFio()+ " Id less then Id " +this.getFio();
            case 0:
                return  other.getFio() +" and "+ this.getFio() +" Id equals " ;
            default:
               return "Wrong operation!";
        }
    }


    public String equalsFioTo(User other) {
        //Compare ID of other user and this user .Return String.
        boolean b = this.fio.equals(other.fio);
        if (b) return "User "+ this.id +" and "+other.id+" FIO equals!";
        else return "User "+ this.id +" and "+other.id+" FIO NOT equals!";
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

    //Constructors
    public User(Integer id, String fio, String phone, String email){
        this.id=id;
        this.fio=fio;
        this.phone=phone;
        this.email=email;
    }

    public User(){}
}
