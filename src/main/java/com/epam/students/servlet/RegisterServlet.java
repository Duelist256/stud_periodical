package com.epam.students.servlet;

import com.epam.students.dao.UserDao;
import com.epam.students.model.User;
import com.epam.students.service.PasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    private UserDao userDao;

    public RegisterServlet() {
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String login = request.getParameter("email");
        String password = request.getParameter("pass");

        User newUser = new User();
        newUser.setName(name);
        newUser.setLogin(login);

        String salt = PasswordUtil.generateSalt();
        try {
            password = PasswordUtil.hashPassword(password, salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        newUser.setSalt(salt);
        newUser.setPassword(password);

        userDao.addUser(newUser);

        request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
