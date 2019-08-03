package ru.eltex;

import ru.eltex.entity.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
         Server.serverRun();
//        System.out.println(Hibernate.getAllUserData());
    }
}