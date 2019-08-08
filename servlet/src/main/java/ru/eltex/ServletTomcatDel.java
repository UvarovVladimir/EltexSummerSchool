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

@WebServlet("/remove_user")
public  class ServletTomcatDel extends HttpServlet {
//    public static String str23 = "dfsdfsdfsdfsdfsdfslkjlkjf";
    protected  void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        response.setContentType("application/json");
//        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie : cookies) {
//            System.out.println(cookie.getName() + ":" + cookie.getValue());
//        }
//        response.addCookie(new Cookie("user", "Tom"));
        String line = Hibernate.removeUser("136");
        PrintWriter writer = response.getWriter();
        try {
            writer.println("Delete was created");
        } finally {
            writer.close();
        }
    }
}
