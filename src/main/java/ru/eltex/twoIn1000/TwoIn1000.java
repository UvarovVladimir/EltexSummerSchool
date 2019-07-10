package ru.eltex.twoIn1000;

import java.math.BigInteger;

public class TwoIn1000 {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("2");
        a = a.pow(1000);
        System.out.println(a);
    }
}
