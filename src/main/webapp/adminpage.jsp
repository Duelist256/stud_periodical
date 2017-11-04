<%--
  Created by IntelliJ IDEA.
  User: Duelist
  Date: 03.11.2017
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
<center>
    <h1>Periodicals Editor</h1>
</center>

<div align="center">
    <form action="/new" method="post">
        <input type="submit" value='Add New Periodical'>
    </form>
    <form action="/adminpage" method="get">
        <input type="submit" value='Refresh List'>
    </form>
    <table border="1" cellpadding="5">
        <caption><h2>List of Periodicals</h2></caption>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Description</th>
            <th>Publisher</th>
            <th>Genre</th>
            <th>Price</th>
            <th>Image Path</th>
            <th colspan="2">Actions</th>
        </tr>
        <c:forEach var="periodical" items="${periodicals}">
            <tr>
                <td><c:out value="${periodical.getId()}" /></td>
                <td><c:out value="${periodical.getTitle()}" /></td>
                <td><c:out value="${periodical.getDescription()}" /></td>
                <td><c:out value="${periodical.getPublisher()}" /></td>
                <td><c:out value="${periodical.getGenre()}" /></td>
                <td><c:out value="${periodical.getPrice()}" /></td>
                <td><c:out value="${periodical.getImgPath()}" /></td>
                <td>
                    <form action="/edit" method="post">
                        <input type="hidden" name="id" value='${periodical.getId()}'>
                        <input type="submit" value='Edit'>
                    </form>
                </td>
                <td>
                    <form action="/delete" method="post">
                        <input type="hidden" name="delete" value='${periodical.getId()}'>
                        <input type="submit" value='Delete'>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
