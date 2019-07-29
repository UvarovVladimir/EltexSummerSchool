package ru.eltex;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Phone")
public  class Phone {

    @Id
    @GeneratedValue
    private Long id;
    @Getter
    @Setter
    @Column(name = "`number`")
    private String number;

    @ManyToOne
    @JoinColumn(name = "person_id",
            foreignKey = @ForeignKey(name = "PERSON_ID_FK")
    )
    private Person person;

    public Phone() {
    }

    public Phone(String number) {
        this.number = number;
    }

    //Getters and setters are omitted for brevity

}