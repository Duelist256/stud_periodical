<%@ page import="com.epam.students.servlet.LoginServlet" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: arina
  Date: 02.11.17
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="css/bootstrap.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>

<html>
<head>
    <title>Admin</title>
</head>
<body>
<%
    String language = LoginServlet.getLanguage();
    String country = LoginServlet.getCountry();
    ResourceBundle resourceBundle = ResourceBundle.getBundle("resources", new Locale(language, country));
%>
<div class="container">
    <div class="row">
        <h2><% out.print(new String(resourceBundle.getString("adminPage").getBytes("ISO-8859-1"), "UTF-8"));%></h2>
        <p align="right">
            <a href="/language?name=ru"><img src="img/Russia.png" width="40" height="40" alt="RU"></a>
            <a href="/language?name=uc"><img src="img/United-Kingdom.png" width="40" height="40" alt="US"></a>
        </p>
        <div class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="myNavbar">
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <h2>Table of all</h2>
    <p>Name of issue</p>
    <input class="form-control" id="myInput" type="text" placeholder="Search..">
    <br>
    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th><% out.print(new String(resourceBundle.getString("Title").getBytes("ISO-8859-1"), "UTF-8"));%></th>
            <th><% out.print(new String(resourceBundle.getString("Publisher").getBytes("ISO-8859-1"), "UTF-8"));%></th>
            <th><% out.print(new String(resourceBundle.getString("Price").getBytes("ISO-8859-1"), "UTF-8"));%></th>
        </tr>
        </thead>


        <tbody id="myTable">
        <%--<c:forEach var="all" items="${list}">--%>
         <%--<script>setter()</script>--%>
        <%--</c:forEach>--%>
        <%----%>
        </tbody>
    </table>
</div>

<script>
    $(document).ready(function(){
        $("#myInput").on("keyup", function() {
            var value = $(this).val().toLowerCase();
            $("#myTable tr").filter(function() {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        });
    });

    var setter =function(array){
        array.forEach(function (t) {
           t.getTitle() + t.getGenre() + t.getPrice();
        })
    }

    var RestGet = function() {
        $.ajax({
            type: 'GET',
            url:  "http://localhost:8080/showissue",
            dataType: 'json',
            async: true,
            success: function(result) {
                console.log("success " + JSON.stringify(result));
                setter(result);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });
    }

    document.addEventListener("DOMContentLoaded", RestGet());
</script>


</body>
</html>
