<%@ page import="com.epam.students.servlet.LoginServlet" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %><%--
  Created by IntelliJ IDEA.
  User: Duelist
  Date: 05.11.2017
  Time: 1:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="css/style.css">
<%
    String language = LoginServlet.getLanguage();
    String country = LoginServlet.getCountry();
    ResourceBundle resourceBundle = ResourceBundle.getBundle("resources", new Locale(language, country));
%>
<html>
<head>
    <title>Reset password</title>
</head>
<body class="login">
<c:choose>

    <c:when test="${reset}">
        <form method="post" action="resetPassword">
            <input type="hidden" name="emailChange" value="approveChange">
            <td align="right"><% out.print(new String(resourceBundle.getString("newpassword").getBytes("ISO-8859-1"), "UTF-8"));%></td>
            <td align="left"><input class="login-field" type="password" name="pass"/></td>
            <hr>
            <td align="right"><input type="submit"
                                     value=<% out.print(new String(resourceBundle.getString("approve").getBytes("ISO-8859-1"),"UTF-8"));%>>
            </td>
        </form>
    </c:when>
    <c:otherwise>
        <%-- Email input--%>
        <form method="post" action="resetPassword">
            <input type="hidden" name="emailChange" value="changeEmail">
            <td align="right"><% out.print(new String(resourceBundle.getString("email").getBytes("ISO-8859-1"), "UTF-8"));%></td>
            <td align="left"><input class="login-field" type="text" name="email"/></td>
            <hr>
            <td align="right"><input type="submit"
                                     value=<% out.print(new String(resourceBundle.getString("reset").getBytes("ISO-8859-1"),"UTF-8"));%>>
            </td>
        </form>
    </c:otherwise>
</c:choose>
</body>
</html>
