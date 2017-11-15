<%--
  Created by IntelliJ IDEA.
  User: arina
  Date: 08.11.17
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="css/bootstrap.css" rel="stylesheet">
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="i18n.login"/>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Story purchases</title>
</head>
<body>
<div class="container">
    <div class="row">
        <h2><fmt:message key="yourPurchases"/></h2>
        <p align="right">
            <a href="/language?lan=ru"><img src="img/Russia.png" width="40" height="40"
                                            alt="RU"></a>
            <a href="/language?lan=en"><img src="img/United-Kingdom.png" width="40" height="40" alt="US">
            </a></p>

        <div class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav navbar-left">
                        <li>
                            <a href="/page?num=1" class="btn btn-link" data-toggle="modal" data-target="#MyBox">
                                <fmt:message key="backshop"/>
                            </a>
                        </li>
                        <li>
                            <a href="/mybox" class="btn btn-link" data-toggle="modal" data-target="#MyBox">
                                <fmt:message key="backtobox"/>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <c:forEach var="periodicalBought" items="${pb}">
            <div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
                <div class="thumbnail">
                    <img src="${periodicalBought.getImgPath()}" alt="Image unavailable">
                    <div class="caption">
                        <h4><a href="#"> ${periodicalBought.getTitle()} </a></h4>
                        <p>${periodicalBought.getDescription()}</p>
                        <button type="button" class="btn btn-success"><fmt:message
                                key="read"/></button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>
