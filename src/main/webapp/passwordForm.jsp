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
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="resources" />
<link rel="stylesheet" href="css/style.css">

<html lang="${language}">
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
            <td align="right"><fmt:message key="newpassword" /></td>
            <td align="left"><input class="login-field" type="password" name="pass"/></td>
            <hr>
            <td align="right"><input type="submit" value=<fmt:message key="approve" />>
            </td>
        </form>
    </c:when>
    <c:otherwise>
        <%-- Email input--%>
        <form method="post" action="resetPassword">
            <input type="hidden" name="emailChange" value="changeEmail">

            <td align="right"><fmt:message key="email"/></td>
            <td align="left"><input class="login-field" type="text" name="email"/></td>
            <c:if test="${error != null}">
                <td>
                    <font color="red">
                        <fmt:message key="invalidemail" />
                    </font>
                </td>
            </c:if>
            <hr width="125%">
            <td align="right"><input type="submit"
                                     value=<fmt:message key="reset" />>
            </td>
        </form>
    </c:otherwise>
</c:choose>
</body>
</html>
