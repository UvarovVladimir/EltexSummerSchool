package ru.eltex.hierarchy;

public class Sales {
    //varible
    String name;
    Double cost;
    //get set
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getCost() {
        return cost;
    }
    public void setCost(Double cost) {
        this.cost = cost;
    }

    //Constructor
    public Sales(String name, Double cost){
        this.name=name;
        this.cost=cost;
    }

}
