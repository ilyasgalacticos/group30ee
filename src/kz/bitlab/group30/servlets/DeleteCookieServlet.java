package kz.bitlab.group30.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/deletecookie")
public class DeleteCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie cookies[] = request.getCookies();
        if(cookies!=null){
            for(Cookie c : cookies){
                if(c.getName().equals("user_name_cookie")){
                    c.setMaxAge(0);
                    response.addCookie(c);
                }
                if(c.getName().equals("user_surname_cookie")){
                    c.setMaxAge(0);
                    response.addCookie(c);
                }
                if(c.getName().equals("user_age_cookie")){
                    c.setMaxAge(0);
                    response.addCookie(c);
                }
            }
        }

        System.out.println("HELLO");

        response.sendRedirect("/");
    }
}
