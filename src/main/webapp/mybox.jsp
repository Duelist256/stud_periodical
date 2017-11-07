<%--
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
            <a href="/language?lan=ru"><img src="img/Russia.png" width="40" height="40"
                                            alt="RU"></a>
            <a href="/language?lan=en"><img src="img/United-Kingdom.png" width="40" height="40" alt="US">
            </a></p>

        <div class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav navbar-
                    right">
                        <a href="/issue.jsp">
                            <button type="button" class="btn btn-link" data-toggle="modal" data-target="#MyBox">
                                <fmt:message key="backshop"/>
                            </button>
                        </a>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <h3><fmt:message key="purchases"/></h3>
    <div class="table-responsive">
        <table class="table">
            <thead>
            <div class="row" align="center" style="border: 1px solid grey">
                <div class="col-sm-3">
                    <h4><fmt:message key="Title"/></h4>
                </div>
                <div class="col-sm-3">
                    <h4><fmt:message key="Publisher"/></h4>
                </div>
                <div class="col-sm-3">
                    <h4><fmt:message key="Price"/></h4>
                </div>
                <div class="col-sm-3">
                    <h4><fmt:message key="delete"/></h4>
                </div>
            </div>
            </thead>
            <tbody>
            <c:set var="sum" value="${0}"></c:set>
            <c:forEach var="periodicalList" items="${pl}">
                <div class="row" align="center">
                    <div class="col-sm-3">
                        <h5> ${periodicalList.getTitle()} </h5>
                    </div>
                    <div class="col-sm-3">
                        <h5> ${periodicalList.getPublisher()} </h5>
                    </div>
                    <div class="col-sm-3">
                        <h5> ${periodicalList.getPrice()} </h5>
                    </div>
                    <div class="col-sm-3">
                        <form method="post" action="/mybox?delete=${periodicalList.getId()}">
                            <h5>
                                <button type="submit" class="login-link"><span class="glyphicon glyphicon-trash"></span>
                                </button>
                            </h5>
                        </form>
                    </div>
                </div>
                <c:set var="sum" value="${sum + Integer.valueOf(periodicalList.getPrice())}"/>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <hr>
    <p>
    <h4 align="right"><fmt:message key="Total"/>
        <c:out value="${sum}"/></h4>
    <form action="/mybox?buy=1" method="post">
        <p align="right"><input type="hidden" name="buy" value="ololo">
            <button type="submit" class="btn btn-default" align="right"><h3><span
                    class="glyphicon glyphicon-shopping-cart"></span></h3>
            </button>
        </p>
    </form>
</div>
</body>
</html>
