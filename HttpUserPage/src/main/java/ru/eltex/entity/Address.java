package ru.eltex.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String city;
    private String street;
    private String building;
    // @OneToMany(mappedBy = "address", fetch = FetchType.EAGER)
    //  private Collection<Person> tenants;
// EAGER - коллекция сразу в память, LAZY - при обращении
}