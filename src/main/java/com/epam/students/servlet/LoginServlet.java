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

    public LoginServlet() {
        userService = new UserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("email");
        String password = request.getParameter("pass");

        Cookie cookieUser;
        HttpSession session;

        if (userService.isUserCorrect(login, password)) {
            UserDao userDao = new UserDao();
            String name = userDao.readByEmail(login).getName();
            if (login != null) {
                cookieUser = new Cookie("user", name);
                cookieUser.setMaxAge(60 * 5); //5 mins
                response.addCookie(cookieUser);

                session = request.getSession(true);
                session.setAttribute("userName", name);
            }

            response.sendRedirect("/issue.jsp");
        } else {
            request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (getLanguage().equals("en")) {
            //меняем на русский
            setLanguage("ru");
            req.getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            setLanguage("en");
            req.getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }


    //    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { }
}
