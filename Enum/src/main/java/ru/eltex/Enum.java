package ru.eltex;
import java.util.Scanner;
public class Enum {
    public static void main (String[] args) {
        System.out.println("Enter day of week: ");
        Scanner reader = new Scanner(System.in);
        String s = reader.nextLine();
        switch (WorkDay.valueOf(s.toUpperCase())){
            case MONDAY:
                System.out.println("5 Days to weekend");
                break;
            case TUESDAY:
                System.out.println("4 Days to weekend");
                break;
            case WEDNESDAY:
                System.out.println("3 Days to weekend");
                break;
            case THURSDAY:
                System.out.println("2 Days to weekend");
                break;
            case FRIDAY:
                System.out.println("1 Day to weekend");
                break;
            case SATURDAY:
                System.out.println("It's weekend");
                break;
            case SUNDAY:
                System.out.println("It's weekend");
                break;




        }
    }
}