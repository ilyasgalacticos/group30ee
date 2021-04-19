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
                    <%
                        Items item = (Items) request.getAttribute("tovar");
                        if(item!=null){
                    %>
                        <form action="/edititem" method="post">
                            <input type="hidden" name="id" value="<%=item.getId()%>">
                            <div class="form-group">
                                <label>NAME : </label>
                                <input type="text" name="item_name" placeholder="Insert item name" class="form-control" value="<%=item.getName()%>">
                            </div>
                            <div class="form-group">
                                <label>PRICE : </label>
                                <input type="text" name="item_price" placeholder="Insert item price" class="form-control" value="<%=item.getPrice()%>">
                            </div>
                            <div class="form-group">
                                <label>AMOUNT : </label>
                                <input type="text" name="item_amount" placeholder="Insert item amount" class="form-control" value="<%=item.getAmount()%>">
                            </div>
                            <div class="form-group">
                                <label>COUNTRY : </label>
                                <select class="form-control" name="country_id">
                                    <%
                                        ArrayList<Countries> strany = (ArrayList<Countries>)request.getAttribute("stranalar");
                                        if(strany!=null){
                                            for(Countries co : strany){
                                    %>
                                    <option value="<%=co.getId()%>" <% if(co.getId()==item.getCountry().getId()){ out.print("selected");}%> >

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
                                    SAVE ITEM
                                </button>
                                <button class="btn btn-danger" type="button" data-toggle="modal" data-target="#deleteItemModal">
                                    DELETE ITEM
                                </button>
                            </div>
                        </form>
                        <div class="modal fade" id="deleteItemModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <form action="/deleteitem" method="post">
                                        <input type="hidden" name="id" value="<%=item.getId()%>">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="staticBackdropLabel">Confirm Delete Item</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            Are you sure?
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">CANCEL</button>
                                            <button class="btn btn-danger">YES</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    <%
                        }else{
                    %>
                        <h1 class="text-center">404 ITEM NOT FOUND</h1>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
