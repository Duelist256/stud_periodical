<%--
  Created by IntelliJ IDEA.
  User: Duelist
  Date: 25.10.2017
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="i18n.login"/>

<link href="css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="css/style1.css">
<html>


<head>
    <title>Register</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="panel panel-primary">
            <div class="panel-body">
                <form name="regForm" method="POST" action="register" role="form">
                    <div class="form-group">
                        <h2>Create account <a href="/language?lan=ru"><img src="img/United-Kingdom.png" align="right"
                                                                           width="40"
                                                                           height="40" alt="US">
                        </a>
                            <a href="/language?lan=en"><img src="img/Russia.png" align="right" width="40" height="40"
                                                            alt="RU"></a></h2>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="signupName"><fmt:message key="name"/></label>
                        <input id="signupName" pattern="^[A-Za-z0-9]{4,20}$" required title="Length should be 4 at least!"
                               type="text" name="name" maxlength="50" class="form-control">
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="signupEmail"><fmt:message key="email"/></label>
                        <input id="signupEmail" pattern="^[A-Za-z0-9]{8,20}$" required title="Length should be 8 at least!"
                               type="email" name="email" maxlength="50" class="form-control">
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="signupPassword"><fmt:message key="password"/></label>
                        <input id="signupPassword" pattern="^[A-Za-z0-9]{4,20}$" required title="Length should be 4 at least!"
                               type="password" name="pass" maxlength="25" class="form-control"
                               placeholder="at least 6 characters" length="40" value="">
                    </div>
                    <div class="form-group">
                        <button id="signupSubmit" type="submit" value="Register" class="btn btn-info btn-block">Create
                            your account
                        </button>
                    </div>
                    <hr>
                    </p>Already have an account? <a href="login.jsp">Sign in</a></p>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
