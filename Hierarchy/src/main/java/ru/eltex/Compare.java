package ru.eltex;

import java.util.ArrayList;

public class Compare {
    public static void compareId(Developer developer, ArrayList<Manager> listManag) {
        System.out.println("     ***Compare ID of one Developer and all Managers *** ");
        for (Manager manager : listManag) {
            System.out.println(developer.compareIdTo(manager));//Compare Id Developer№2 with managers Id
        }
    }

    public static void equalsFioTo(Developer developer, ArrayList<Manager> listManag) {
        System.out.println("     ***Equals or not ID of one Developer and all Managers *** ");
        for (Manager manager : listManag) {
            System.out.println(developer.equalsFioTo(manager));
        }
    }
}
