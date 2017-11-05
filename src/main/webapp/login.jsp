<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %>
<%@ page import="com.epam.students.servlet.LoginServlet" %><%--
  Created by IntelliJ IDEA.
  User: Duelist
  Date: 23.10.2017
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <td align="left"><input class="login-field" type="text" name="email"/></td>

    <td align="right"><% out.print(new String(resourceBundle.getString("password").getBytes("ISO-8859-1"), "UTF-8")); %></td>
    <td align="left"><input class="login-field" type="password" name="pass"/></td>
    <hr>
    <td align="right"><input type="submit"
                             value=<% out.print(new String(resourceBundle.getString("login").getBytes("ISO-8859-1"),"UTF-8"));%>>
    </td>

</form>
<form method="post" action="register.jsp">
    <input type="submit"
           value="<% out.print(new String(resourceBundle.getString("register").getBytes("ISO-8859-1"),"UTF-8")); %>"/>
</form>


<form method="post" action="/resetPassword">
    <input type="submit"
           value="<% out.print(new String(resourceBundle.getString("forgot").getBytes("ISO-8859-1"),"UTF-8")); %>"/>
</form>

<%--change language--%>

<form method="get" action="login">
    <input type="submit"
           value="<%out.print(new String(resourceBundle.getString("Change_Language").getBytes("ISO-8859-1"),"UTF-8"));%>"/>
</form>


</body>
</html>
