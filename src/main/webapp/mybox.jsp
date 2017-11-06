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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="i18n.login"/>

<script type="text/javascript" src="main.js"></script>
<link href="css/bootstrap.css" rel="stylesheet">
<html>
<head>
    <title>MyBox</title>

</head>
<body>

<div class="container">
    <div class="row">
        <h2><fmt:message key="box"/></h2>
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
                                <fmt:message key="backshop"/>
                            </button>
                        </a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <h2><fmt:message key="purchases"/></h2>
    <table class="table">
        <thead>
        <tr>
            <th><fmt:message key="Title"/></th>
            <th><fmt:message key="Publisher"/></th>
            <th><fmt:message key="Price"/></th>
            <th><fmt:message key="buy"/></th>
            <th><fmt:message key="delete"/></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="periodicalList" items="${pl}">
            <tr>
                <td> ${periodicalList.getTitle()}</td>
                <td> ${periodicalList.getPublisher()}</td>
                <td> ${periodicalList.getPrice()}</td>
                <td>
                    <form method="put" action="#">
                        <input class="login-link" type="submit"
                               value="<fmt:message key="buy"/>"
                        />
                    </form>
                </td>
                <td>
                    <form method="post" action="/mybox?delete=${periodicalList.getId()}">
                        <input class="login-link" type="submit"
                               value="<fmt:message key="delete"/>"/>
                    </form>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>


</body>
</html>
