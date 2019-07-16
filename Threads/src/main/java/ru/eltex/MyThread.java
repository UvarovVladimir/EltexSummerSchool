package ru.eltex;

import java.net.Socket;

public class MyThread implements Runnable {
    static Integer a =0;
    @Override
    public void run() {
        System.out.println("ПОТОК  RUN"+ Thread.currentThread().getName());
        a=a+1;
        System.out.println(a);
    }
    //Конструктор
    public MyThread(Socket sock){

        }






}
