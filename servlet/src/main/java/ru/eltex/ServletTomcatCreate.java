package ru.eltex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//"text/html"
//"application/json"

@WebServlet("/create")
public  class ServletTomcatCreate extends HttpServlet {
//    public static String str23 = "dfsdfsdfsdfsdfsdfslkjlkjf";
    protected  void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        response.setContentType("application/json");
//        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie : cookies) {
//            System.out.println(cookie.getName() + ":" + cookie.getValue());
//        }
//        response.addCookie(new Cookie("user", "Tom"));
        Hibernate.createUsers();
        PrintWriter writer = response.getWriter();
        try {
            writer.println("Users was created");
        } finally {
            writer.close();
        }
    }
}
