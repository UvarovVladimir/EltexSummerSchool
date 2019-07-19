package ru.eltex;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Stream {
    public static void main (String[] args) {
        System.out.println("Stream API: ");
        List<Integer> list = new ArrayList<Integer>();
        for (int i =0; i<1000;i++){
            list.add(i);
        }
        System.out.println(list.stream()
                .map(x->  x*x)
                .reduce(0, (acc, x) -> acc + x));


    }
}