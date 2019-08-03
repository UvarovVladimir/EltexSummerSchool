package ru.eltex;

import java.io.*;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {
    public static void main (String[] args) {
        System.out.println("Сервак: ");

        try (ServerSocket s = new ServerSocket(8080)) {
            while (true) {
                Socket client = s.accept();
                new Thread( ()-> {
                    try {
                        InputStream inStream = client.getInputStream();
                        OutputStream outStream = client.getOutputStream();
                        Scanner in = new Scanner(inStream);
                        PrintWriter out = new PrintWriter(outStream);

                        String[] arr = in.nextLine().split(" ");

                        FileReader fr = new FileReader(arr[1]);
                        Scanner inFile = new Scanner(fr);
                        String httpPage = "";
                        while (inFile.hasNextLine()) {
                            String line = inFile.nextLine();
                            httpPage += line;
                        }
                         System.out.println(Thread.currentThread().getName()+httpPage);

                        Integer iii = httpPage.length();
                        String str = "HTTP/1.0 200 OK\n" +
                                "Content-Length:" + iii + "\n" +
                                "\n" +
                                httpPage;

                        out.write(str);
                        out.flush();
                        client.close();
                    } catch (IOException error){
                        System.err.print(error.getMessage());
                    }
                }).start();
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


    }
}