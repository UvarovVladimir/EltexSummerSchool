package ru.eltex.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Address {
    private String city;
    private String street;
    private String building;
    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER)
    private Collection<Person> tenants;
// EAGER - коллекция сразу в память, LAZY - при обращении
}