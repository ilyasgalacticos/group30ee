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
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <td>ID</td>
                                <td>NAME</td>
                                <td>PRICE</td>
                                <td>AMOUNT</td>
                                <td>COUNTRY</td>
                                <td width="10%;">DETAILS</td>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ArrayList<Items> items = (ArrayList<Items>) request.getAttribute("tovary");
                                if(items!=null){
                                    for(Items it : items){
                            %>
                                <tr>
                                    <td>
                                        <%
                                            out.print(it.getId());
                                        %>
                                    </td>
                                    <td>
                                        <%
                                            out.print(it.getName());
                                        %>
                                    </td>
                                    <td>
                                        <%
                                            out.print(it.getPrice());
                                        %>
                                    </td>
                                    <td>
                                        <%
                                            out.print(it.getAmount());
                                        %>
                                    </td>
                                    <td>
                                        <%=it.getCountry().getName() + " / " + it.getCountry().getCode()%>
                                    </td>
                                    <td>
                                        <a href="/details?id=<% out.print(it.getId());%>" class="btn btn-primary btn-sm">DETAILS</a>
                                    </td>
                                </tr>
                            <%
                                    }
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
