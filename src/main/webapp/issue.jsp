<%@ page import="com.epam.students.servlet.LoginServlet" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: arina
  Date: 30.10.17
  Time: 0:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript" src="main.js"></script>
<link href="css/bootstrap.css" rel="stylesheet">

<html>
<head>
    <title>Issue</title>
</head>
<body>
<%
    String language = LoginServlet.getLanguage();
    String country = LoginServlet.getCountry();
    ResourceBundle resourceBundle = ResourceBundle.getBundle("resources", new Locale(language, country));
%>
<div class="container">
    <div class="row">
        <h2><% out.print(new String(resourceBundle.getString("catalog").getBytes("ISO-8859-1"), "UTF-8"));%></h2>
        <p align="right">
            <a href="/language?name=ru"><img src="img/Russia.png" width="40" height="40"
                                                                alt="RU"></a>

            <a href="/language?name=en"><img src="img/United-Kingdom.png" width="40" height="40" alt="US">

            </a></p>

        <div class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="myNavbar">
                    <h1 class="btn btn-link" data-toggle="modal" data-target="#MyBox">
                        Hello <% if (session.getAttribute("userName") != null) {
                        out.print(session.getAttribute("userName").toString());
                    }%>
                    </h1>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/mybox.jsp">
                            <button type="button" class="btn btn-link" data-toggle="modal" data-target="#MyBox">
                                <% out.print(new String(resourceBundle.getString("box").getBytes("ISO-8859-1"), "UTF-8"));%>
                            </button>
                        </a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="container">

        <ul class="nav nav-tabs">
            <li class="active">

            <li>
                <a href="/getall"><% out.print(new String(resourceBundle.getString("getAll").getBytes("ISO-8859-1"), "UTF-8"));%><span
                        class="badge"> 5</span></a></li>
            <li>
                <a href="#"><% out.print(new String(resourceBundle.getString("category1").getBytes("ISO-8859-1"), "UTF-8"));%>
                    <span class="badge"> 5</span></a></li>
            <li>
                <a href="#"><% out.print(new String(resourceBundle.getString("category2").getBytes("ISO-8859-1"), "UTF-8"));%><span
                        class="badge"> 6</span></a></li>

        </ul>
        <hr>

        <!-- Блоки с текстом!!!!!! -->
        <c:forEach var="all" items="${list}">
            <div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
                <div class="thumbnail">
                    <img src="http://placehold.it/300x240" alt="">
                    <div class="caption">
                        <h4><a href="#"> ${all.getTitle()} </a></h4>
                        <p>${all.getDescription()}</p>
                        <a href="#"
                           class="btn btn-success"><% out.print(new String(resourceBundle.getString("details").getBytes("ISO-8859-1"), "UTF-8"));%></a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
