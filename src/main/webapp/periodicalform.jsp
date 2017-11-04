<%--
  Created by IntelliJ IDEA.
  User: Duelist
  Date: 04.11.2017
  Time: 0:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Periodical Form</title>
</head>
<body>
<center>
    <h1>Periodicals Editor</h1>
</center>
<div align="center">
    <form action="/adminpage" method="post">
        <input type="submit" value='Back To List'>
    </form>
    <c:if test="${periodical != null}">
    <form action="/update" method="post">
        </c:if>
        <c:if test="${periodical == null}">
        <form action="/insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${periodical != null}">
                            Edit Periodical
                        </c:if>
                        <c:if test="${periodical == null}">
                            Add New Periodical
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${periodical != null}">
                    <input type="hidden" name="id" value="<c:out value='${periodical.getId()}' />"/>
                </c:if>
                <tr>
                    <th>Title:</th>
                    <td>
                        <input type="text" name="title" size="45"
                               value="<c:out value='${periodical.getTitle()}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Description:</th>
                    <td>
                        <input type="text" name="description" size="45"
                               value="<c:out value='${periodical.getDescription()}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Publisher:</th>
                    <td>
                        <input type="text" name="publisher" size="45"
                               value="<c:out value='${periodical.getPublisher()}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Genre:</th>
                    <td>
                        <input type="text" name="genre" size="45"
                               value="<c:out value='${periodical.getGenre()}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Price:</th>
                    <td>
                        <input type="text" name="price" size="5"
                               value="<c:out value='${periodical.getPrice()}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Image Path:</th>
                    <td>
                        <input type="text" name="imgPath" size="45"
                               value="<c:out value='${periodical.getImgPath()}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save"/>
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>
