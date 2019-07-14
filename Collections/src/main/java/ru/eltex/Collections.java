package ru.eltex;

import java.util.*;

public class Collections {
    public static void main(String[] args) {

        //ArrayList
        long startTime = System.currentTimeMillis();
        ArrayList<Integer> arrList  = new ArrayList<>();
        for (int i =0; i<1000000;i++){
            arrList.add(i);
        }
        long executeTimeList =System.currentTimeMillis() - startTime; // Вычисление времени выполнения
        long startTimeNano = System.nanoTime();
        arrList.remove(999999);
        long executeTimeNanoList =System.nanoTime() - startTimeNano; // Вычисление времени выполнения удаления
        System.out.println("Время добавления ArrayList в мс: " + executeTimeList);
        System.out.println("Время удаления элемента ArrayList в нс: " + executeTimeNanoList);

        //LinkedList
        startTime = System.currentTimeMillis();
        LinkedList<Integer> arrLink = new LinkedList<>();
        for (int i =0; i<1000000;i++){
            arrLink.add(i);
        }
        long executeTimeLink =System.currentTimeMillis() - startTime; // Вычисление времени выполнения
        startTimeNano = System.nanoTime();
        arrLink.remove(999999);
        long executeTimeNanoLink =System.nanoTime() - startTimeNano; // Вычисление времени выполнения удаления
        System.out.println("Время добавления LinkList в мс: " + executeTimeLink);
        System.out.println("Время удаления элемента LinkList в нс: " + executeTimeNanoLink);

        //TreeSet
        startTime = System.currentTimeMillis();
        SortedSet<Integer> arrTree = new TreeSet<>();
        for (int i =0; i<1000000;i++){
            arrTree.add(i);
        }
        long executeTimeTree =System.currentTimeMillis() - startTime; // Вычисление времени выполнения
        startTimeNano = System.nanoTime();
        arrTree.remove(999999);
        long executeTimeNanoTree =System.nanoTime() - startTimeNano; // Вычисление времени выполнения удаления
        System.out.println("Время добавления TreeSet в мс: " + executeTimeTree);
        System.out.println("Время удаления элемента TreeSet в нс: " + executeTimeNanoTree+"\n");


        //WIN CREATE
        if  (executeTimeList < executeTimeLink  && executeTimeList < executeTimeTree)
            System.out.println("Быстрее всех элементы созданы в ArrayList");
        if  (executeTimeLink < executeTimeList  && executeTimeLink < executeTimeTree)
            System.out.println("Быстрее всех элементы созданы в LinkedList");
        if  (executeTimeTree < executeTimeList  && executeTimeTree < executeTimeLink)
            System.out.println("Быстрее всех элементы созданы в TreeSet");

        //WIN DELATE
        if  (executeTimeNanoList < executeTimeNanoLink  && executeTimeNanoList < executeTimeNanoTree)
            System.out.println("Быстрее всех элемент удален в ArrayList"+"\n");
        if  (executeTimeNanoLink < executeTimeNanoList  && executeTimeNanoLink < executeTimeNanoTree)
            System.out.println("Быстрее всех элемент удален в LinkedList"+"\n");
        if  (executeTimeNanoTree < executeTimeNanoList  && executeTimeNanoTree < executeTimeNanoLink)
            System.out.println("Быстрее всех элемент удален в TreeSet"+"\n");


        //HashSet
        startTime = System.currentTimeMillis();
        HashSet<Integer> arrHashSet = new HashSet<>();
        for (int i =0; i<1000000;i++){
            arrHashSet.add(i);
        }
        long executeTimeHashSet =System.currentTimeMillis() - startTime; // Вычисление времени выполнения ArrayList
        startTimeNano = System.nanoTime();
        arrHashSet.remove(999999);
        long executeTimeNanoHashSet = System.nanoTime() - startTimeNano; // Вычисление времени выполнения ArrayList
        System.out.println("Время добавления HashSet в мс: " + executeTimeHashSet);
        System.out.println("Время удаления элемента HashSet в нс: " + executeTimeNanoHashSet);

        //HashMap
        startTime = System.currentTimeMillis();
        Map<Integer, Integer> arrhashMap = new HashMap<Integer, Integer>();
        for (int i =0; i<1000000;i++){
            arrhashMap.put(i , i);
        }
        long executeTimeHashMap =System.currentTimeMillis() - startTime; //   Вычисление времени выполнения ArrayList
        startTimeNano = System.nanoTime();
        arrhashMap.remove(999999);
        long executeTimeNanoHashMap = System.nanoTime() - startTimeNano; // Вычисление времени выполнения ArrayList
        System.out.println("Время добавления HashMap в мс: " + executeTimeHashMap);
        System.out.println("Время удаления элемента HashMap в нс: " + executeTimeNanoHashMap+"\n");

        if  (executeTimeHashSet < executeTimeHashMap)
            System.out.println("Быстрее всех элементы созданы в HashSet");
        else
            System.out.println("Быстрее всех элементы созданы в HashMap");
        if  (executeTimeNanoHashSet < executeTimeNanoHashMap)
            System.out.println("Быстрее всех элементы удалены в HashSet");
        else
            System.out.println("Быстрее всех элементы удалены в HashMap");
    }
}
