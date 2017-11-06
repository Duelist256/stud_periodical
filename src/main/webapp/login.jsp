<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %>
<%@ page import="com.epam.students.servlet.LoginServlet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="css/style1.css">

</head>
<%--
  Created by IntelliJ IDEA.
  User: Duelist
  Date: 23.10.2017
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Login</title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookieReq : cookies) {
            if (cookieReq.getName().equals("user") && !(cookieReq.getValue().equals(""))) {
                session = request.getSession(true);
                session.setAttribute("userName", cookieReq.getValue());
                request.getServletContext().getRequestDispatcher("/issue.jsp").forward(request, response);
            }
        }
    }
%>
<%
    String language = LoginServlet.getLanguage();
    String country = LoginServlet.getCountry();
    ResourceBundle resourceBundle = ResourceBundle.getBundle("resources", new Locale(language, country));
%>
<div class="container">
    <div class="row">
        <div class="panel panel-primary">
            <div class="panel-body">
                <form method="POST" action="login" role="form">
                    <div class="form-group">
                        <h2>Sign in
                            <a href="/language?name=engg"><img src="img/United-Kingdom.png" align="right" width="40"
                                                               height="40" alt="US">
                            </a>
                            <a href="/language?name=russ"><img src="img/Russia.png" align="right" width="40" height="40"
                                                               alt="RU"></a></h2>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="signupEmail">Email</label>
                        <input id="signupEmail" type="email" name="email" maxlength="50" class="form-control">
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="signupPassword">Password</label>
                        <input id="signupPassword" type="password" name="pass" maxlength="25" class="form-control"
                               placeholder="at least 6 characters" length="40">
                    </div>
                    <div class="form-group">
                        <button type="submit" value="login" class="btn btn-info btn-block">login</button>
                    </div>
                    <p>Don't have an account? <a href="register.jsp">Registration</a></p>
                    </p> I forgot my password! <a href="#">Change password</a></p>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
