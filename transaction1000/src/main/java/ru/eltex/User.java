package ru.eltex;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@ToString
@AllArgsConstructor
@NoArgsConstructor
class User {
    public void fromCSV(String str) {
        String[] arr = str.split(",");            //Parse Line
        if (arr.length >= 4) {
            this.setId(Integer.parseInt(arr[0]));
            this.setFio(arr[1]);
            this.setPhone(arr[2]);
            this.setEmail(arr[3]);
        }
    }

    //Variable
    @Getter
    @Setter
    @Id
    private Integer id;
    @Getter
    @Setter
    private String fio;
    @Getter
    @Setter
    private String phone;
    @Getter
    @Setter
    private String email;
/*
    //Constructors
    User(Integer id, String fio, String phone, String email) {
        this.id = id;
        this.fio = fio;
        this.phone = phone;
        this.email = email;
    }

    User() {
    }*/
}
