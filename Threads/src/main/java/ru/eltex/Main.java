package ru.eltex;
class Main{

    public static void main (String[] args) {
        System.out.println("Потоки:");
        for (int i =0;i<10;i++) {
            Runnable r = new MyThread();
            Thread t = new Thread(r);
            t.start();
        }

    }
}