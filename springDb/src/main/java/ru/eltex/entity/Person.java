package ru.eltex.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Person {
    private String name;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Address address;
}