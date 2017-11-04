package com.epam.students.servlet;

import com.epam.students.model.User;
import com.epam.students.service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/login")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String login = req.getParameter("email");
        String password = req.getParameter("pass");

        UserService userService = new UserService();
        HttpServletResponse response = (HttpServletResponse) resp;

        User user = userService.checkUser(login, password);
        if (user != null) {
            if (user.isAdmin() == 1) {
                response.sendRedirect("/adminpage");
            } else {
                response.sendRedirect("/issue.jsp");
            }
        } else {
            req.getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
