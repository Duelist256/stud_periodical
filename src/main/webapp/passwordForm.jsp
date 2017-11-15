<%--
  Created by IntelliJ IDEA.
  User: Duelist
  Date: 05.11.2017
  Time: 1:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="i18n.login"/>

<link href="css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="css/style.css">

<html lang="${language}">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Reset password</title>
</head>
<body class="login">
<div class="container">
<div class="row">
    <div class="panel panel-primary">
        <div class="panel-body">

            <c:choose>
                <c:when test="${reset}">
                    <form method="post" action="resetPassword" role="form">
                        <input type="hidden" name="emailChange" value="approveChange">
                        <input type="hidden" name="email" value="${useremail}">
                        <div class="form-group">
                            <label class="control-label" for="newPassword"><fmt:message key="newPassword"/></label>

                            <input id="newPassword" type="password" name="pass" maxlength="25" class="form-control"
                                   pattern="^[A-Za-z0-9]{4,}$" required title="<fmt:message key="loginRegPattern"/>">
                        </div>

                        <div class="form-group">
                            <button type="submit" class="btn btn-info btn-block"><fmt:message key="approve"/></button>
                        </div>
                    </form>
                </c:when>
                <c:otherwise>
                    <%-- Email input--%>
                    <form method="post" action="resetPassword">
                        <input type="hidden" name="emailChange" value="changeEmail">

                        <div class="form-group">
                            <label class="control-label" for="userEmail"><fmt:message key="email"/></label>
                            <input id="userEmail" type="email" name="email"  class="form-control">
                        </div>

                        <div class="form-group">
                            <button type="submit" class="btn btn-info btn-block"><fmt:message key="reset"/></button>
                        </div>
                    </form>
                </c:otherwise>
            </c:choose>
        </div>
        <p align="center">
            <c:if test="${requestScope.error != null}">
                <label class="text-danger"> <fmt:message key="invalidEmail"/> </label>
            </c:if>
        </p>
    </div>
</div>
</div>
</body>
</html>
