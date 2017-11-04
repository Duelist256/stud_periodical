package com.epam.students.servlet;

import com.epam.students.dao.UserDao;
import com.epam.students.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static String language = "ru";
    private static String country = "US";

    public static String getLanguage() {
        return language;
    }

    public static void setLanguage(String language) {
        LoginServlet.language = language;
    }

    public static String getCountry() {
        if (language.equals("ru"))
            return "RU";
        else return "US";
    }

    private UserService userService;
    private Cookie cookieUserName;
    private Cookie cookieUserId;
    private HttpSession session;  //?

    public LoginServlet() {
        userService = new UserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("email");
        String password = request.getParameter("pass");

        if (userService.isUserCorrect(login, password)) {
            UserDao userDao = new UserDao();

            if (login != null) {
                String name = userDao.readByEmail(login).getName();
                int id = userDao.readByEmail(login).getId();


                cookieUserName = new Cookie("user", name);
                cookieUserName.setMaxAge(60 * 3); //5 mins
                response.addCookie(cookieUserName);

                cookieUserId = new Cookie("userId", String.valueOf(userDao.readByEmail(login).getId()));
                cookieUserName.setMaxAge(60 * 3); //5 mins
                response.addCookie(cookieUserName);

                session = request.getSession(true);
                session.setAttribute("userName", name);
            }

            response.sendRedirect("/issue.jsp");
        } else {
            request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
