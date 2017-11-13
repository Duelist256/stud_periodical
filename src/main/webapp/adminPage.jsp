<%--
  Created by IntelliJ IDEA.
  User: Duelist
  Date: 03.11.2017
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="i18n.login"/>
<link href="css/bootstrap.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
<center>
    <h1>Periodicals Editor</h1>
</center>
<div class="container">
    <div class="row">

        <p align="right">
            <a href="/language?lan=ru"><img src="img/Russia.png" width="40" height="40"
                                            alt="RU"></a>

            <a href="/language?lan=en"><img src="img/United-Kingdom.png" width="40" height="40" alt="US">

            </a></p>

        <div class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="myNavbar">
                    <p class="btn btn-link" data-toggle="modal" data-target="#MyBox">
                        Hello <% if (session.getAttribute("userName") != null) {
                        out.print(session.getAttribute("userName").toString());
                    }%>
                    </p>

                    <div class="nav navbar-nav navbar-right">
                        <form action="/adminpage" method="post">
                            <input type="submit" class="btn btn-info btn-block" value="<fmt:message key="addNew"/> ">
                            <input type="hidden" class="btn btn-info btn-block" name='action' value="new">
                        </form>
                        <form action="/logout" method="get">
                            <input type="submit" class="btn btn-info btn-block" value="<fmt:message key="logout"/> ">
                        </form>

                    </div>

                </div>
            </div>
        </div>
    </div>

    <div class="container">

        <table class="table">

            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Publisher</th>
                <th>Genre</th>
                <th>Price</th>
                <th>Image</th>
                <th colspan="2">Actions</th>
            </tr>
            <c:forEach var="periodical" items="${periodicals}">
                <tr class="active">
                    <td><c:out value="${periodical.getId()}"/></td>
                    <td><c:out value="${periodical.getTitle()}"/></td>
                    <td><c:out value="${periodical.getDescription()}"/></td>
                    <td><c:out value="${periodical.getPublisher()}"/></td>
                    <td><c:out value="${periodical.getGenre()}"/></td>
                    <fmt:formatNumber type="number" maxFractionDigits="2"
                                       minFractionDigits="2"
                                       pattern="###.00"
                                       value="${periodical.getPrice()}"
                                       var="periodicalPrice"/>
                    <td><c:out value="${periodicalPrice}"/></td>
                    <%--<td><c:out value="${periodical.getImgPath()}"/></td>--%>
                   <td> <img src="<c:out value="${periodical.getImgPath()}"/>" class="img-thumbnail" height="50" width="50"></td>
                    <td>
                        <form action="/adminpage" method="post">
                            <input type="hidden" name="action" value='edit'>
                            <input type="hidden" name="id" value='${periodical.getId()}'>
                            <input type="submit" class="btn btn-info btn-block" value='<fmt:message key="edit"/>'>
                        </form>
                    </td>
                    <td>
                        <form action="/adminpage" method="post">
                            <input type="hidden" name="action" value='delete'>
                            <input type="hidden" name="delete" value='${periodical.getId()}'>
                            <input type="submit" class="btn btn-info btn-block" value='<fmt:message key="delete"/> '>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>

