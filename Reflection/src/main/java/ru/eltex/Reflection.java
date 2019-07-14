package ru.eltex;


import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Reflection {

    public static void main(String[] args) {
        User user = new User(123, "Yfg", "92310433223", "ert@jljk");
        Class userInfo = user.getClass();
        System.out.println("Имя класса: " + userInfo.getName());

        System.out.println("Имена переменных класса " + userInfo.getName() +":");
        Field[] declaredFields = userInfo.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field.getName());
        }

        System.out.println("Имена методов класса " + userInfo.getName() +":");
        Method[] declaredMethods = userInfo.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method.getName());
        }
    }
}
