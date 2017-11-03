package com.epam.students.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ErrorHandler", urlPatterns = "/ErrorHandler")
public class ErrorHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handle(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handle(req, resp);
    }

    private void handle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer statusCode = (Integer) req.getAttribute("javax.servlet.error.status_code");

        if (statusCode.equals(403)) {
            resp.sendRedirect("/403.html");
        } else if (statusCode.equals(404)) {
            resp.sendRedirect("/404.html");
        } else {
            resp.sendRedirect("/500.html");
        }
    }
}
