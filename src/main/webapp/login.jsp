<%--
  Created by IntelliJ IDEA.
  User: Duelist
  Date: 23.10.2017
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources"/>
<link rel="stylesheet" href="css/style.css">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Title</title>
</head>
<body class="login">
<p align="right">
    <a href="/language?name=russ"><img src="img/Russia.png" width="40" height="40"
                                        alt="RU"></a>

    <a href="/language?name=engg"><img src="img/United-Kingdom.png" width="40" height="40"
                                        alt="US"></a>
</p>

<form method="post" action="login">


    <td align="right"><fmt:message key="email"/></td>
    <td align="left"><input class="login-field" type="text" name="email"/></td>

    <td align="right"><fmt:message key="password"/></td>
    <td align="left"><input class="login-field" type="password" name="pass"/></td>
    <hr>
    <td align="right"><input type="submit"
                             value="<fmt:message key="login"/>">
    </td>

</form>
<form method="post" action="register.jsp">
    <input type="submit"
           value="<fmt:message key="register"/>"/>
</form>


<form method="post" action="/resetPassword">
    <input type="submit"
           value="<fmt:message key="forgot"/>"/>
</form>

</body>
</html>
