<%@ page import="com.epam.students.servlet.LoginServlet" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %><%--
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
<%--<%--%>
    <%--String language = LoginServlet.getLanguage();--%>
    <%--String country = LoginServlet.getCountry();--%>
    <%--ResourceBundle resourceBundle = ResourceBundle.getBundle("resources", new Locale(language, country));--%>
<%--%>--%>
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
            <%--<td align="right"><% out.print(new String(resourceBundle.getString("newpassword").getBytes("ISO-8859-1"), "UTF-8"));%></td>--%>
            <td align="right"><fmt:message key="newpassword" /></td>
            <td align="left"><input class="login-field" type="password" name="pass"/></td>
            <hr>
            <td align="right"><input type="submit" value=<fmt:message key="approve" />>
                                     <%--value=<% out.print(new String(resourceBundle.getString("approve").getBytes("ISO-8859-1"),"UTF-8"));%>>--%>
            </td>
        </form>
    </c:when>
    <c:otherwise>
        <%-- Email input--%>
        <form method="post" action="resetPassword">
            <input type="hidden" name="emailChange" value="changeEmail">
            <%--<td align="right"><% out.print(new String(resourceBundle.getString("email").getBytes("ISO-8859-1"), "UTF-8"));%></td>--%>
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
                                     <%--value=<% out.print(new String(resourceBundle.getString("reset").getBytes("ISO-8859-1"),"UTF-8"));%>>--%>
            </td>
        </form>
    </c:otherwise>
</c:choose>
</body>
</html>
