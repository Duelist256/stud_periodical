<%--
  Created by IntelliJ IDEA.
  User: arina
  Date: 30.10.17
  Time: 0:11
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

<link href="css/bootstrap.css" rel="stylesheet">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
    var RestGet = function (id) {
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/bought?id=' + id,
            dataType: 'json',
            async: true,
            success: function (result) {
                console.log(result);
            },
            error: function (jqXHR, textStatus, errorThrown) {
//                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });
    }
</script>

<html>
<head>
    <title>Issue</title>
</head>
<body>
<div class="container">
    <div class="row">
        <h2><fmt:message key="catalog"/></h2>
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
                    <ul class="nav navbar-nav navbar-right">
                        <a href="/mybox" class="btn btn-link" data-toggle="modal" data-target="#MyBox">
                            <fmt:message key="box"/>
                        </a>
                        <a href="/logout" class="btn btn-link" data-toggle="modal" data-target="#MyBox">
                            <fmt:message key="logout"/>
                        </a>

                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="container">

        <ul class="nav nav-tabs">
            <li class="active">

            <li>
                <a href="/getall"><fmt:message key="getAll"/> <span
                        class="badge">  20</span></a></li>
        </ul>
        <!-- Блоки с текстом!!!!!! -->
        <c:forEach var="all" items="${list}">
            <div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
                <div class="thumbnail">
                    <img src="http://placehold.it/300x240" alt="">
                    <div class="caption">
                        <h4><a href="#"> ${all.getTitle()} </a></h4>
                        <p>${all.getDescription()}</p>
                        <button type="button" class="btn btn-success" onclick="RestGet(${all.getId()})"><fmt:message
                                key="buy"/></button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<nav class="text-center">
    <ul class="pagination">
        <li>
            <a href="#">
                <i class="glyphicon glyphicon-chevron-left"></i>
            </a>
        </li>
        <li><a href="/page?num=1">1</a></li>
        <li><a href="/page?num=2">2</a></li>
        <li>
            <a href="#">
                <i class="glyphicon glyphicon-chevron-right"></i>
            </a>
        </li>
    </ul>
</nav>

</body>
</html>
