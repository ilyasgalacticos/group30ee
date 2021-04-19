<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.group30.db.Items" %>
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
                <div class="col-12">
                    <%
                        Items item = (Items) request.getAttribute("tovar");
                        if(item!=null){
                    %>
                        <div class="jumbotron">
                            <h1 class="display-4">
                                <%=item.getName()%><%--<% out.print(item.getName()); %>--%>
                            </h1>
                            <p class="lead">
                                FOR <%=item.getPrice()%> KZT
                            </p>
                            <hr class="my-4">
                            <p>
                                <%=item.getAmount()%> items remained, from <%=item.getCountry().getName() + " / "+item.getCountry().getCode()%>
                            </p>
                            <p>
                                <a href="/edititem?id=<%=item.getId()%>" class="btn btn-primary btn-sm">EDIT ITEM</a>
                            </p>
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
