package main.java.ru.eltex.collections;

import java.util.ArrayList;

public class Collections {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ArrayList arrList  = new ArrayList();
        //for (int i =0; i<100;i++){
        //    arrList.add(i);
        //}
       // for (int i =0; i<100;i++){
       //     arrList.remove(i);
        //}
        long executeTime =System.currentTimeMillis() - startTime; // Вычисление времени выполнения ArrayList
        System.out.println("Время выполнения Array List в мс: " + executeTime);


    }
}
