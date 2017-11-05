<%@ page import="com.epam.students.servlet.LoginServlet" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: arina
  Date: 01.11.17
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript" src="main.js"></script>
<link href="css/bootstrap.css" rel="stylesheet">
<html>
<head>
    <title>MyBox</title>

</head>
<body>
<%
    String language = LoginServlet.getLanguage();
    String country = LoginServlet.getCountry();
    ResourceBundle resourceBundle = ResourceBundle.getBundle("resources", new Locale(language, country));
%>
<%

%>
<div class="container">
    <div class="row">
        <h2><% out.print(new String(resourceBundle.getString("box").getBytes("ISO-8859-1"), "UTF-8"));%></h2>
        <p align="right">
            <a href="/language?name=rus"><img src="img/Russia.png" width="40" height="40"
                                              alt="RU"></a>

            <a href="/language?name=eng"><img src="img/United-Kingdom.png" width="40" height="40" alt="US">

            </a></p>

        <div class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/issue.jsp">
                            <button type="button" class="btn btn-link" data-toggle="modal" data-target="#MyBox">
                                <% out.print(new String(resourceBundle.getString("backshop").getBytes("ISO-8859-1"), "UTF-8"));%>
                            </button>
                        </a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <h2><% out.print(new String(resourceBundle.getString("purchases").getBytes("ISO-8859-1"), "UTF-8"));%></h2>
    <table class="table">
        <thead>
        <tr>
            <th><% out.print(new String(resourceBundle.getString("Title").getBytes("ISO-8859-1"), "UTF-8"));%></th>
            <th><% out.print(new String(resourceBundle.getString("Publisher").getBytes("ISO-8859-1"), "UTF-8"));%></th>
            <th><% out.print(new String(resourceBundle.getString("Price").getBytes("ISO-8859-1"), "UTF-8"));%></th>
            <th><% out.print(new String(resourceBundle.getString("delete").getBytes("ISO-8859-1"), "UTF-8"));%></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="periodicalList" items="${pl}">
            <tr>
                <td> ${periodicalList.getTitle()}</td>
                <td> ${periodicalList.getPublisher()}</td>
                <td> ${periodicalList.getPrice()}</td>
                <td>
                    <form method="post" action="/mybox?delete=${periodicalList.getId()}">
                        <input class="login-link" type="submit"
                               value="<% out.print(new String(resourceBundle.getString("delete").getBytes("ISO-8859-1"),"UTF-8")); %>"/>
                    </form>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>


</body>
</html>
