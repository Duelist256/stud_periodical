package com.epam.students.servlet;

import com.epam.students.model.User;
import com.epam.students.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserService userService;

    public LoginServlet() {
        userService = new UserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("email");
        String password = request.getParameter("pass");

        User user = userService.checkUser(login, password);
        if (user != null) {
            if (user.isAdmin() == 1) {
                response.sendRedirect("/adminpage");
            } else {
                response.sendRedirect("/issue.jsp");
            }
        } else {
            request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("language") == null || req.getSession().getAttribute("language").equals("ru")) {

            req.getSession().setAttribute("language","en");
            req.getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);

        } else {
            req.getSession().setAttribute("language","ru");
            req.getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }

}
