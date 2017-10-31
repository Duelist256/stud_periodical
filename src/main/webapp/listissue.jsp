<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arina
  Date: 30.10.17
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>All issue</title>
</head>
<body>
<div class="title">
    <p>
    <h1 align="center">List of issue</h1></p>
</div>

<c:forEach var="all" items="${list}">
    <td></td>
    <td>${all.getTitle()}</td>
    <td>${all.getDescription()}</td>
    <td>price</td>
    <hr>
</c:forEach>

</body>
</html>
