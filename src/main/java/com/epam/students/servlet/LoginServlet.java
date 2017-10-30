package com.epam.students.servlet;

import com.epam.students.dao.UserDao;
import com.epam.students.model.Language;
import com.epam.students.service.PasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserDao userDao;

    public LoginServlet() {
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("email");
        String password = request.getParameter("pass");

        String salt = userDao.getSaltByLogin(login);

        if (salt.equals("no user")) {
            request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }

        try {
            password = PasswordUtil.hashPassword(password, salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        if (userDao.isUserCorrect(login, password)) {
            response.sendRedirect("/issue.jsp");
        } else {
            request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Language.getLanguage().equals("en")) {
            //меняем на русский
            Language.setLanguage("ru");
            req.getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            Language.setLanguage("en");
            req.getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }

    //    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { }
}
