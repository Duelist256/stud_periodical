package com.epam.students.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.epam.students.servlet.Language.language;

@WebServlet(name = "LanguageServlet", urlPatterns = "/language")
public class LanguageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String referer = req.getHeader("referer");
        if (req.getParameter("lan").equals("ru")) {
            language = "ru";
            req.getSession().setAttribute("language", language);

        } else if (req.getParameter("lan").equals("en")) {
            language = "en";
            req.getSession().setAttribute("language", language);
        }
        resp.sendRedirect(referer);
    }
}