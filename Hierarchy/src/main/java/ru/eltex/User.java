package ru.eltex;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@ToString
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
    @Getter @Setter @Id
    private Integer id;
    @Getter    @Setter
    private String fio;
    @Getter    @Setter
    private String phone;
    @Getter    @Setter
    private String email;


    //Constructors
    User(Integer id, String fio, String phone, String email){
        this.id=id;
        this.fio=fio;
        this.phone=phone;
        this.email=email;
    }

     User(){}
}
