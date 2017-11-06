package com.epam.students.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.epam.students.servlet.LoginServlet.getLanguage;
import static com.epam.students.servlet.LoginServlet.setLanguage;

@WebServlet(name = "LanguageServlet", urlPatterns = "/language")
public class LanguageServlet extends HttpServlet {

    // TODO Refactor this

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("name").equals("ru")) {
            setLanguage("ru");
            req.getSession().setAttribute("language", getLanguage());
            req.getServletContext().getRequestDispatcher("/issue.jsp").forward(req, resp);
        } else if (req.getParameter("name").equals("en")) {
            setLanguage("en");
            req.getSession().setAttribute("language", getLanguage());
            req.getServletContext().getRequestDispatcher("/issue.jsp").forward(req, resp);
        } else if (req.getParameter("name").equals("rus")) {
            setLanguage("ru");
            req.getServletContext().getRequestDispatcher("/mybox.jsp").forward(req, resp);
        } else if (req.getParameter("name").equals("eng")) {
            setLanguage("en");
            req.getServletContext().getRequestDispatcher("/mybox.jsp").forward(req, resp);
        } else if (req.getParameter("name").equals("russ")) {
            setLanguage("ru");
            req.getSession().setAttribute("language", getLanguage());
            req.getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        } else if (req.getParameter("name").equals("engg")) {
            setLanguage("en");
            req.getSession().setAttribute("language", getLanguage());
            req.getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}