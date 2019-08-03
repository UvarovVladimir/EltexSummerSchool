package ru.eltex;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void serverRun() {
        System.out.println("Сервак запущен: ");

        try (ServerSocket s = new ServerSocket(8080)) {
            while (true) {
                Socket client = s.accept();
                new Thread(() -> {
                    try {
                        InputStream inStream = client.getInputStream();
                        OutputStream outStream = client.getOutputStream();
                        Scanner in = new Scanner(inStream);
                        PrintWriter out = new PrintWriter(outStream);
//обработка входящего запроса
                        String[] arr = in.nextLine().split(" ");
                        String[] arrdir = arr[1].split("/");
//Заполняем тело сообщения - строку httpPage
                        String httpPage = "";
//выбираем по первому полю в REST
                        switch (arrdir[1]) {
                            case "get_user": {
                                System.out.println("Показать одного пользователя c id: " + arrdir[2]);
                                httpPage = "<!DOCTYPE>\n" +
                                        "</html>\n" +
                                        "<body>\n" +
                                        "<h1>" + Hibernate.getUserData(arrdir[2]) + "</h1> \n" +
                                        "</body>\n" +
                                        "</html>";
                                break;
                            }

                            case "remove_user": {
                                System.out.println("Удалить пользователя c id: " + arrdir[2]);
                                httpPage = "<!DOCTYPE>\n" +
                                        "</html>\n" +
                                        "<body>\n" +
                                        "<h1>" + Hibernate.removeUser(arrdir[2]) + "</h1> \n" +
                                        "</body>\n" +
                                        "</html>";
                                break;
                            }

                            case "get_users": {
                                System.out.println("Показать всех пользователей: " );
                                httpPage = "<!DOCTYPE>\n" +
                                        "</html>\n" +
                                        "<body>\n" +
                                        "<h1>" + Hibernate.getAllUserData() + "</h1> \n" +
                                        "</body>\n" +
                                        "</html>";
                                break;
                            }

                            case "create": {
                                Hibernate.createUsers();
                                System.out.println("Создать 5 пользователей: " );
                                httpPage = "<!DOCTYPE>\n" +
                                        "</html>\n" +
                                        "<body>\n" +
                                        "<h1>" + "Users are created" + "</h1> \n" +
                                        "</body>\n" +
                                        "</html>";
                                break;
                            }

                            case "script": {
                                FileReader fr = new FileReader("/home/vladimir/EltexSummerSchool/HttpUserPage/" +
                                        "src/main/resources/index.html");
                                Scanner inFile = new Scanner(fr);
                                while (inFile.hasNextLine()) {
                                    String line = inFile.nextLine();
                                    httpPage += line;
                                }
                                break;
                            }


                            case "script2": {

                                    httpPage = "line";
                                }
                                break;
                            }



//Cообщение о некорректном запросе
                            default: {
                                FileReader fr = new FileReader("/home/vladimir/EltexSummerSchool/HttpUserPage/" +
                                        "src/main/resources/IncorrReq.html");
                                Scanner inFile = new Scanner(fr);
                                while (inFile.hasNextLine()) {
                                    String line = inFile.nextLine();
                                    httpPage += line;
                                }
                            }
                        }
//Заполняем верхние поля для отправки
                        String send = "HTTP/1.0 200 OK\n" +
                                "Content-Length:" + httpPage.length() + "\n" +
                                "\n" +
                                httpPage;
//отправка сообщения
                        System.out.println(Thread.currentThread().getName() + httpPage);
                        out.write(send);
                        out.flush();
                        client.close();
                    } catch (IOException error) {
                        System.err.print(error.getMessage());
                    }
                }).start();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}