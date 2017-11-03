package com.epam.students.servlet;

import com.epam.students.dao.PeriodicalDao;
import com.epam.students.model.Periodical;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BuyServlet", urlPatterns = "/bought")
public class BuyServlet extends HttpServlet {
    static int count = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println(id + " <----");
        Cookie cookie = new Cookie("id" + String.valueOf(count), id);
        count++;
        cookie.setMaxAge(60 * 10);
        resp.addCookie(cookie);
        req.getServletContext().getRequestDispatcher("/issue.jsp").forward(req, resp);
    }
}
