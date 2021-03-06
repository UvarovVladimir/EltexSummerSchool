package ru.eltex;

import ru.eltex.interfaces.CSV;

public class Sale implements CSV {
    //Interface
    public  String toCSV(){
        return this.name +","+this.cost;
    }
    public void fromCSV(String str){
        String[] arr = str.split(" цена:");
        if (arr.length>=2) {
            this.name = arr[0];
            this.cost = Double.parseDouble(arr[1]);
        }
    }
    //varible
    String name = "";
    Double cost = 0.0;
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
    public Sale(String name, Double cost){
        this.name=name;
        this.cost=cost;
    }
    public Sale(){};

}
