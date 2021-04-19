package kz.bitlab.group30.servlets;

import kz.bitlab.group30.db.Countries;
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

@WebServlet(value = "/additem")
public class AddItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long countryId = Long.parseLong(request.getParameter("country_id"));
        String name = request.getParameter("item_name");
        String price = request.getParameter("item_price");
        String amount = request.getParameter("item_amount");

        Countries checkCountry = DBManager.getCountry(countryId);
        if(checkCountry!=null) {
            Items item = new Items();
            item.setName(name);
            item.setAmount(Integer.parseInt(amount));
            item.setPrice(Double.parseDouble(price));
            item.setCountry(checkCountry);

            DBManager.addItem(item);
        }

        response.sendRedirect("/");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Countries> countries = DBManager.getAllCountries();
        request.setAttribute("stranalar", countries);
        request.getRequestDispatcher("/additem.jsp").forward(request, response);
    }
}
