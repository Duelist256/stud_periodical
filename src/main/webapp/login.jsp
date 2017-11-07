<%--
  Created by IntelliJ IDEA.
  User: Duelist
  Date: 23.10.2017
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

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
    <title>Title</title>
</head>
<body class="login">
<form method="post" action="login">

    <div align="left"><fmt:message key="email"/></div>
    <c:set var="login" value="${requestScope.error}"/>
    <div align="left">
        <input class="login-field" type="text" name="email"
               value="<c:out value="${login}" default=""/>"/>
    </div>

    <div align="left"><fmt:message key="password"/></div>
    <div align="left"><input class="login-field" type="password" name="pass"/></div>
    <hr width="125%">
    <div align="right"><input type="submit" value="<fmt:message key="login"/>"></div>

</form>

<form method="post" action="register.jsp">
    <input class="login-link" type="submit"
           value="<fmt:message key="register"/>"/>
</form>

<form method="post" action="/resetPassword">
    <input class="login-link" type="submit" value="<fmt:message key="forgot" />"/>
</form>

<%--change language--%>

<form method="get" action="login">
    <input type="submit" value="<fmt:message key="changeLanguage"/>"/>
</form>


<c:if test="${login != null}">
    <div style="color: red">
        <fmt:message key="invalidMsg"/>
    </div>
</c:if>

</body>
</html>
