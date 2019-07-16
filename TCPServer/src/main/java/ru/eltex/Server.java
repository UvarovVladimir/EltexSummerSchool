package ru.eltex;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main (String[] args) {
        System.out.println("Сервак: ");

        try (ServerSocket s = new ServerSocket(1050)) {
            Socket client = s.accept();
            InputStream inStream = client.getInputStream();
            OutputStream outStream = client.getOutputStream();
            Scanner in = new Scanner(inStream);
            PrintWriter out = new PrintWriter(outStream);
            out.write("Hello123");
            out.flush();
            //String line222 = in.nextLine();
            //System.out.println(line222);
            //System.out.flush();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }



















        try (Socket s = new Socket("172.21.0.130", 2223)) {
            InputStream inStream = s.getInputStream();
            OutputStream outStream = s.getOutputStream();
            Scanner in = new Scanner(inStream);
            PrintWriter out = new PrintWriter(outStream);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
                out.write(line);
                out.flush();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}