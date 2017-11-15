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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="i18n.login"/>
<html>
<head>
    <title>Periodical Form</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div style="text-align: center;">
    <h1><fmt:message key="editor" /></h1>
</div>
<div class="container">
    <div class="row">

        <p align="right">
            <a href="/language?lan=ru"><img src="img/Russia.png" width="40" height="40"
                                            alt="RU"></a>

            <a href="/language?lan=en"><img src="img/United-Kingdom.png" width="40" height="40" alt="US">

            </a>
        </p>

        <div class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="myNavbar">
                    <div class="nav navbar-nav navbar-right">

                        <form class="navbar-form" action="/adminpage" method="post">
                            <input type="submit" class="btn btn-info btn-block" value="<fmt:message key="backToListBtn" />">
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>

    <c:if test="${periodical != null}">
    <form action="/adminpage" method="post" enctype="multipart/form-data">
        <input type="hidden" name="action" value="update">
        </c:if>
        <c:if test="${periodical == null}">
        <form action="/adminpage" method="post" enctype="multipart/form-data">
            <input type="hidden" name="action" value="insert">
            </c:if>
            <table class="table">
                <caption>
                    <h2>
                        <c:choose>
                            <c:when test="${periodical != null}">
                                <fmt:message key="editPeriodical"/>
                            </c:when>
                            <c:when test="${periodical == null}">
                                <fmt:message key="addPeriodical"/>
                            </c:when>
                        </c:choose>
                    </h2>
                </caption>
                <c:if test="${periodical != null}">
                    <input type="hidden" name="id" value='${periodical.getId()}'/>
                </c:if>
                <tr class="active">
                    <th><fmt:message key="Title" />:</th>
                    <td>
                        <input type="text" name="title" size="45"
                               value='${periodical.getTitle()}'
                        />
                    </td>
                </tr>
                <tr class="active">
                    <th><fmt:message key="Description" />:</th>
                    <td>
                        <input type="text" name="description" size="45"
                               value='${periodical.getDescription()}'
                        />
                    </td>
                </tr>
                <tr class="active">
                    <th><fmt:message key="Publisher" />:</th>
                    <td>
                        <input type="text" name="publisher" size="45"
                               value='${periodical.getPublisher()}'
                        />
                    </td>
                </tr>
                <tr class="active">
                    <th><fmt:message key="Genre" />:</th>
                    <td>
                        <input type="text" name="genre" size="45"
                               value='${periodical.getGenre()}'
                        />
                    </td>
                </tr>
                <tr class="active">
                    <th><fmt:message key="Price" />:</th>
                    <td>
                        <input type="text" name="price" size="5"
                               value="${periodical.getPrice()}"
                               required pattern="^(?:\d{1,10}|(?!.{12})\d+\.\d+)$"
                               title="Only digits. Example: 42, 1.12, 1234.37"/>
                    </td>
                </tr>
                <tr class="active">
                    <th><fmt:message key="Image" />:</th>
                    <td>
                        <input type="file" name="file" size="45" />
                        <input type="hidden" name="imgPath" value='${periodical.getImgPath()}' size="45" />

                    </td>
                </tr>
                <tr class="active">
                    <td colspan="2" align="center">
                        <input type="submit" class="btn btn-info" value="<fmt:message key="saveBtn"/> "/>
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>
