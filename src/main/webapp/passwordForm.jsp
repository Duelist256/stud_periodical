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

<c:choose>
    <c:when test="${sessionScope.language == 'en'}">
        <fmt:setLocale value="en"/>
    </c:when>
    <c:otherwise>
        <fmt:setLocale value="ru"/>
    </c:otherwise>
</c:choose>
<fmt:setBundle basename="i18n.login"/>

<link rel="stylesheet" href="css/style.css">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Reset password</title>
</head>
<body class="login">
<c:choose>

    <c:when test="${reset}">
        <form method="post" action="resetPassword">
            <input type="hidden" name="emailChange" value="approveChange">
            <input type="hidden" name="email" value="${useremail}">
            <div align="left"><fmt:message key="newPassword"/></div>
            <div align="left"><input class="login-field" type="password" name="pass"/></div>
            <hr width="125%">
            <div align="right"><input type="submit" value=<fmt:message key="approve"/>>
            </div>
        </form>
    </c:when>
    <c:otherwise>
        <%-- Email input--%>
        <form method="post" action="resetPassword">
            <input type="hidden" name="emailChange" value="changeEmail">

            <div align="left"><fmt:message key="email"/></div>
            <div align="left"><input class="login-field" type="text" name="email"/></div>
            <c:if test="${error != null}">
                <div style="color:red">
                    <fmt:message key="invalidEmail"/>
                </div>
            </c:if>
            <hr width="125%">
            <div align="right"><input type="submit"
                                      value=<fmt:message key="reset"/>>
            </div>
        </form>
    </c:otherwise>
</c:choose>
</body>
</html>
