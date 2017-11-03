package com.epam.students.servlet;

import com.epam.students.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    private UserService userService;

    public RegisterServlet() {
        userService = new UserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String login = request.getParameter("email");
        String password = request.getParameter("pass");

        userService.addUser(login, password, name);
        throw new UnsupportedOperationException();
//        request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
