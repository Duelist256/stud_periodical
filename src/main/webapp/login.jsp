<%--
  Created by IntelliJ IDEA.
  User: Duelist
  Date: 23.10.2017
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="css/style1.css">
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>

<fmt:setLocale value="${language}"/>

<fmt:setBundle basename="i18n.login"/>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Title</title>
</head>
<body class="login">
<div class="container">
    <div class="row">
        <div class="panel panel-primary">
            <div class="panel-body">
                <form method="POST" action="login" role="form">
                    <div class="form-group">
                        <h2>Sign in
                            <a href="/language?lan=ru"><img src="img/Russia.png" align="right" width="40" height="40"
                                                               alt="RU"></a>

                            <a href="/language?lan=en"><img src="img/United-Kingdom.png" align="right" width="40"
                                                               height="40" alt="US"></a></h2>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="signupEmail"><fmt:message key="email"/></label>
                        <input id="signupEmail" type="email" name="email" value="<c:out value="${error}" default=""/>" maxlength="50" class="form-control"
                               pattern="^[A-Za-z0-9,@]{1,20}$" required>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="signupPassword"><fmt:message key="password"/></label>
                        <input id="signupPassword" type="password" name="pass" maxlength="25" class="form-control"
                               pattern="^[A-Za-z0-9]{1,20}$" required>
                    </div>
                    <div class="form-group">
                        <button type="submit" value="login" class="btn btn-info btn-block"><fmt:message
                                key="login"/></button>
                    </div>
                    <p>Don't have an account? <a href="register.jsp"><fmt:message key="register"/></a></p>
                </form>
=========
    <div align="left"><fmt:message key="email"/></div>
    <c:set var="login" value="${requestScope.error}"/>
    <div align="left">
        <input class="login-field" type="text" name="email"
               value="<c:out value="${login}" default=""/>"/>
    </div>

    <div align="left"><fmt:message key="password"/></div>
    <div align="left"><input class="login-field" type="password" name="pass"/></div>
    <hr width="125%">
    <div align="right"><input type="submit" value="<fmt:message key="login"/>"></div>

</form>

<form method="post" action="register.jsp">
    <input class="login-link" type="submit"
           value="<fmt:message key="register"/>"/>
</form>

<form method="post" action="/resetPassword">
    <input class="login-link" type="submit" value="<fmt:message key="forgot" />"/>
</form>

<%--change language--%>

<form method="get" action="login">
    <input type="submit" value="<fmt:message key="changeLanguage"/>"/>
</form>


<c:if test="${login != null}">
    <div style="color: red">
        <fmt:message key="invalidMsg"/>
    </div>
</c:if>
>>>>>>>>> Temporary merge branch 2

                <form method="post" action="/resetPassword">
                    <p> I forgot my password!
                        <input type="submit" class="btn btn-link" value="<fmt:message key="forgot"/>"/></p></form>
            </div>
            <c:if test="${requestScope.error != null}">
                <font color=red size=4px>    <fmt:message key="invalidMsg" /> </font>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
