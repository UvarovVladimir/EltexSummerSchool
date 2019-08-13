package ru.eltex;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Client.vkRequest();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
