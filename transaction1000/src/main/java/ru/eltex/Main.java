package ru.eltex;

import com.sun.xml.txw2.output.DumpSerializer;

public class Main {

    public static void main(String[] args) {
        System.out.println("Lets make 1000 Users in MySql");
        Transaction.write1000("Transaction1000");
        Transaction.write1000Transaction("Transaction1000");

    }

}
