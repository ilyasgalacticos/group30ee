<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.group30.db.Items" %>
<%@ page import="kz.bitlab.group30.db.Countries" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <%@include file="head.jsp"%>
    </head>
    <body>
        <div class="container">
            <%@include file="navbar.jsp"%>
        </div>
        <div class="container mt-3">
            <div class="row">
                <div class="col-6 mx-auto">
                    <form action="/additem" method="post">
                        <div class="form-group">
                            <label>NAME : </label>
                            <input type="text" name="item_name" placeholder="Insert item name" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>PRICE : </label>
                            <input type="text" name="item_price" placeholder="Insert item price" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>AMOUNT : </label>
                            <input type="text" name="item_amount" placeholder="Insert item amount" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>COUNTRY : </label>
                            <select class="form-control" name="country_id">
                                <%
                                    ArrayList<Countries> strany = (ArrayList<Countries>)request.getAttribute("stranalar");
                                    if(strany!=null){
                                        for(Countries co : strany){
                                %>
                                    <option value="<%=co.getId()%>">
                                        <%=co.getName() + " - " + co.getCode()%>
                                    </option>
                                <%
                                        }
                                    }
                                %>
                            </select>
                        </div>
                        <div class="form-group">
                            <button class="btn btn-success">
                                ADD ITEM
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
