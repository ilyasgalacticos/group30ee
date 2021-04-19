package kz.bitlab.group30.servlets;

import kz.bitlab.group30.db.DBManager;
import kz.bitlab.group30.db.Items;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Long itemId = -1L;
        try{

            itemId = Long.parseLong(id);

        }catch (Exception e){
        }

        Items item = DBManager.getItem(itemId);

        request.setAttribute("tovar", item);
        request.getRequestDispatcher("/details.jsp").forward(request, response);

    }
}
