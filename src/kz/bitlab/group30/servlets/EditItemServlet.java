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
import java.util.ArrayList;

@WebServlet(value = "/edititem")
public class EditItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("item_name");
        String price = request.getParameter("item_price");
        String amount = request.getParameter("item_amount");

        Long countryId = Long.parseLong(request.getParameter("country_id"));

        Countries checkCountry = DBManager.getCountry(countryId);
        if(checkCountry!=null) {

            Items item = DBManager.getItem(id);

            if (item != null) {
                item.setName(name);
                item.setPrice(Double.parseDouble(price));
                item.setAmount(Integer.parseInt(amount));
                item.setCountry(checkCountry);
                DBManager.saveItem(item);

                response.sendRedirect("/details?id=" + id);

            } else {

                response.sendRedirect("/");

            }

        }else{

            response.sendRedirect("/");

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Long itemId = -1L;
        try{

            itemId = Long.parseLong(id);

        }catch (Exception e){
        }

        Items item = DBManager.getItem(itemId);

        ArrayList<Countries> countries = DBManager.getAllCountries();
        request.setAttribute("stranalar", countries);

        request.setAttribute("tovar", item);
        request.getRequestDispatcher("/edititem.jsp").forward(request, response);

    }
}
