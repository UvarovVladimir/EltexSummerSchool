package main.java.ru.eltex.calculator;
import java.util.Scanner;
public class Calculator {
    public static void main (String[] args) {
        System.out.println("Введите выражение в строку");
        Scanner reader = new Scanner(System.in);
        String s = reader.nextLine();
        String[] tmpStr = s.split(" ");
        Double a =  0.0 ;
        Double b =  0.0 ;
        Double c =  0.0 ;
        if (tmpStr.length>2) {
            a =  Double.valueOf(tmpStr[0]) ;
            b =  Double.valueOf(tmpStr[2]) ;
            switch (tmpStr[1]) {
                case "+":
                    c = a + b;
                    break;
                case "-":
                    c = a - b;
                    break;
                case "*":
                    c = a * b;
                    break;
                case "/":
                    c = a / b;
                    break;
                default:
                    System.out.println("Введена неверная функция");

                    System.out.println("Время выполнения Array List " );
            }
        }
        else
            System.out.println("Введены некорректные данн" );
        System.out.println("Результат:" + c);
    }
}