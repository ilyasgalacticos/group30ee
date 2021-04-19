package kz.bitlab.group30.servlets;

import kz.bitlab.group30.db.DBManager;
import kz.bitlab.group30.db.Items;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value = "/altynay")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Items> items = DBManager.getAllItems();

        request.setAttribute("tovary", items);
        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }
}
