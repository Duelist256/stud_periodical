package com.epam.students.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.students.servlet.LoginServlet.getLanguage;
import static com.epam.students.servlet.LoginServlet.setLanguage;

@WebServlet(name = "LanguageServlet", urlPatterns = "/language")
public class LanguageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String referer = req.getHeader("referer");
        if (req.getParameter("lan").equals("ru")) {
            setLanguage("ru");
            req.getSession().setAttribute("language", getLanguage());

        } else if (req.getParameter("lan").equals("en")) {
            setLanguage("en");
            req.getSession().setAttribute("language", getLanguage());
        }
        resp.sendRedirect(referer);
    }
}