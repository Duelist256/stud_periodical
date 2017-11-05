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
<%
    String language = LoginServlet.getLanguage();
    String country = LoginServlet.getCountry();
    ResourceBundle resourceBundle = ResourceBundle.getBundle("resources", new Locale(language, country));
%>
<html>
<head>
    <title>Title</title>
</head>
<body class="login">
<form method="post" action="login">

    <td align="right"><% out.print(new String(resourceBundle.getString("email").getBytes("ISO-8859-1"), "UTF-8"));%></td>

    <c:set var="login" value="${requestScope.error}" />
    <td align="left"><input class="login-field" type="text" name="email" value="<c:out value="${login}" default=""/>"/></td>

    <td align="right"><% out.print(new String(resourceBundle.getString("password").getBytes("ISO-8859-1"), "UTF-8")); %></td>
    <td align="left"><input class="login-field" type="password" name="pass"/></td>
    <hr>
    <td align="right"><input type="submit"
                             value=<% out.print(new String(resourceBundle.getString("login").getBytes("ISO-8859-1"),"UTF-8"));%>>
    </td>

</form>
<form method="post" action="register.jsp">
    <input class="login-link" type="submit"
           value="<% out.print(new String(resourceBundle.getString("register").getBytes("ISO-8859-1"),"UTF-8")); %>"/>
</form>

<%--change language--%>

<form method="get" action="login">
    <input type="submit"
           value="<%out.print(new String(resourceBundle.getString("Change_Language").getBytes("ISO-8859-1"),"UTF-8"));%>"/>
</form>
<fmt:setBundle basename="resources" var="bundle"/>
<fmt:setLocale value="en"/>
<c:if test="${login != null}">
    <font color=red size=4px>    <fmt:message key="invalid_msg" bundle="${bundle}"/> </font>
</c:if>

</body>
</html>
