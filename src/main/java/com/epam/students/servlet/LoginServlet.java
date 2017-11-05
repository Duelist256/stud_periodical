package com.epam.students.servlet;

import com.epam.students.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private static String language = "ru";
    private static String country = "US";
    private UserService userService;

    public LoginServlet() {
        userService = new UserService();
    }

    public static String getLanguage() {
        return language;
    }

    public static void setLanguage(String language) {
        LoginServlet.language = language;
    }

    public static String getCountry() {
        if (language.equals("ru")) {
            return "RU";
        } else {
            return "US";
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("email");
        String password = request.getParameter("pass");

        if (userService.isUserCorrect(login, password)) {
            response.sendRedirect("/issue.jsp");
        } else {
            request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (getLanguage().equals("en")) {
            setLanguage("ru");
            req.getSession().setAttribute("language", getLanguage());
            req.getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            setLanguage("en");
            req.getSession().setAttribute("language", getLanguage());
            req.getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }


    //    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { }
}
