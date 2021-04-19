package kz.bitlab.group30.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/setcookie")
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("user_name");
        String surname = request.getParameter("user_surname");
        String age = request.getParameter("user_age");

        Cookie nameCookie = new Cookie("user_name_cookie", name);
        nameCookie.setMaxAge(3600);
        Cookie surnameCookie = new Cookie("user_surname_cookie", surname);
        surnameCookie.setMaxAge(3600);
        Cookie ageCookie = new Cookie("user_age_cookie", age);
        ageCookie.setMaxAge(3600);

        response.addCookie(nameCookie);
        response.addCookie(surnameCookie);
        response.addCookie(ageCookie);

        response.sendRedirect("/");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = "No Name";
        String surname = "No Surname";
        String age = "No Age";

        Cookie cookies[] = request.getCookies();
        if(cookies!=null){

            for(Cookie c : cookies){
                if(c.getName().equals("user_name_cookie")){
                    name = c.getValue();
                }
                if(c.getName().equals("user_surname_cookie")){
                    surname = c.getValue();
                }
                if(c.getName().equals("user_age_cookie")){
                    age = c.getValue();
                }
            }

        }

        request.setAttribute("name", name);
        request.setAttribute("surname", surname);
        request.setAttribute("age", age);

        request.getRequestDispatcher("/indexcookie.jsp").forward(request, response);

    }
}
