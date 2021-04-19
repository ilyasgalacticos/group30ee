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
            <div class="row mt-3">
                <div class="col-12">
                    <h3 class="text-center">
                        <%
                            String name = (String)request.getAttribute("name");
                            String surname = (String)request.getAttribute("surname");
                            String age = (String)request.getAttribute("age");

                            out.print(name + " " + surname + " " + age + " years old");

                        %>
                    </h3>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6 mx-auto">
                    <form action="/setcookie" method="post">
                        <div class="form-group">
                            <label>USER NAME : </label>
                            <input type="text" name="user_name" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>USER SURNAME : </label>
                            <input type="text" name="user_surname" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>USER AGE : </label>
                            <select class="form-control" name="user_age">
                                <%
                                    for(int i=0;i<=120;i++){
                                %>
                                    <option value="<%=i%>"><%=i+" years old"%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        <div class="form-group">
                            <button class="btn btn-success">CREATE COOKIE</button>
                            <a href="/deletecookie" class="btn btn-danger">DELETE COOKIE</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
