<%--
  Created by IntelliJ IDEA.
  User: arina
  Date: 30.10.17
  Time: 0:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>issue</title>
</head>
<body>
<h1 align="center">Catalog of issue</h1>

<form method="get" action="/getall">
    <td align="right"><input type="submit" value="Select all"/></td>
</form>
<hr>

<form method="get" action="/getbygenre">
    <select name="clr">
        <option>A</option>
        <option>B</option>
        <option>C</option>
        <option>D</option>
    </select>
    <input type="submit" name="submit" value="Select genre"/>
</form>


</body>
</html>
