<%--
  Created by IntelliJ IDEA.
  User: Duelist
  Date: 23.10.2017
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="login">
    <table>
        <tr>
            <td align="right">Email ID:</td>
            <td align="left"><input type="text" name="email"/></td>
        </tr>
        <tr>
            <td align="right">Password:</td>
            <td align="left"><input type="text" name="pass"/></td>
            <td align="right"><input type="submit" value="Login"/></td>
        </tr>
    </table>
</form>
<form method="post" action="register.jsp">
    <input type="submit" value="Register"/>
</form>
</body>
</html>
