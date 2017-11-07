package com.epam.students.servlet;

import com.epam.students.model.User;
import com.epam.students.service.PasswordUtil;
import com.epam.students.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    private UserService userService;

    public RegisterServlet() {
        userService = new UserService();
    }

    protected void doPost(HttpServletRequest rs, HttpServletResponse response) throws ServletException, IOException {

        String salt = PasswordUtil.generateSalt();
        String hashedPassword = null;

        try {
            hashedPassword = PasswordUtil.hashPassword(rs.getParameter("pass"), salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        User user = User.newBuilder()
                .name(rs.getParameter("name"))
                .login(rs.getParameter("email"))
                .salt(salt)
                .password(hashedPassword)
                .build();

        userService.addUser(user);

        rs.getServletContext().getRequestDispatcher("/login.jsp").forward(rs, response);
    }

}
