package ru.eltex;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Person")
public  class Person {

    @Id
    @GeneratedValue
    private Long id;
    @Getter
    @Setter
    @Column(name = "First Name")
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }


    //Getters and setters are omitted for brevity

}



