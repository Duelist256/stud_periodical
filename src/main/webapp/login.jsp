<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %>
<%@ page import="com.epam.students.servlet.LoginServlet" %><%--
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

<link rel="stylesheet" href="css/style.css">


<c:choose>
    <c:when test="${sessionScope.language == 'en'}">
        <fmt:setLocale value="en"/>
    </c:when>
    <c:otherwise>
        <fmt:setLocale value="ru"/>
    </c:otherwise>
</c:choose>

<fmt:setBundle basename="i18n.login" />

<html>
<head>
    <title>Title</title>
</head>
<body class="login">
<form method="post" action="login">

    <td align="right"><fmt:message key="email"/></td>

    <c:set var="login" value="${requestScope.error}" />
    <td align="left"><input class="login-field" type="text" name="email" value="<c:out value="${login}" default=""/>"/></td>

    <td align="right"><fmt:message key="password"/></td>
    <td align="left"><input class="login-field" type="password" name="pass"/></td>
    <hr>
    <td align="right"><input type="submit" value="<fmt:message key="login"/>"></td>

</form>
<form method="post" action="register.jsp">
    <input class="login-link" type="submit"
           value="<fmt:message key="register"/>"/>
</form>

<%--change language--%>

<form method="get" action="login">
    <input type="submit" value="<fmt:message key="changeLanguage"/>"/>
</form>


<c:if test="${login != null}">
    <font color=red size=4px>    <fmt:message key="invalid_msg" /> </font>
</c:if>

</body>
</html>
