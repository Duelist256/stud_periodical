<%--
  Created by IntelliJ IDEA.
  User: Duelist
  Date: 25.10.2017
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form method="post" action="register">
    <table>
        <tr>
            <td align="right">Name:</td>
            <td align="left"><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td align="right">Email:</td>
            <td align="left"><input type="text" name="email"/></td>
        </tr>
        <tr>
            <td align="right">Password:</td>
            <td align="left"><input type="password" name="pass"/></td>
            <td align="right"><input type="submit" value="Register"/></td>
        </tr>
    </table>
</form>
</body>
</html>
