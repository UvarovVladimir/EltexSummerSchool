package ru.eltex;
import java.util.Scanner;
public class Calculator {
    public static void main (String[] args) {
        System.out.println("Введите выражение в строку: ");
        Scanner reader = new Scanner(System.in);
        String s = reader.nextLine();
        String[] tmpStr = s.split(" ");
        Double a =  123.0 ;
        Double b =  111.0 ;
        Double c =  2222.0 ;
        if (tmpStr.length>2) {
            a =  Double.valueOf(tmpStr[0]) ;
            b =  Double.valueOf(tmpStr[2]) ;
            switch (tmpStr[1]) {                 //Выбор операции
                case "+":
                    c = a + b;  //ahsjfdhlakjsdf
                    break;
                case "-":
                    c = a - b + 1;
                    break;
                case "*":
                    c = a * b; // фывлаожфдылвоа
                    // фджылвоаждфлыова
                    break;
                case "/":
                    c = a / b + 1;
                    break;
                default:
                    System.out.println("Введена неверная функция!");
            }
        }
        else
            System.out.println("Введены некорректные данные!" );
        System.out.println("Результат: " + c);
    }
}