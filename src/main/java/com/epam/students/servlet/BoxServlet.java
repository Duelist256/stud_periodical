package com.epam.students.servlet;

import com.epam.students.dao.PeriodicalDao;
import com.epam.students.model.Periodical;
import com.epam.students.service.PeriodicalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "BoxServlet", urlPatterns = "/mybox")
public class BoxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Periodical> periodicalList = new ArrayList<>();
        PeriodicalDao periodical = new PeriodicalDao();

        List<Cookie> cookieList = new ArrayList<>();
        Cookie[] cookies = req.getCookies();

        for(Cookie cookie : cookies){
            if (cookie.getName().startsWith("id")) {
                periodicalList.add(new PeriodicalDao().read(Integer.valueOf(cookie.getValue())));
                continue;
            }
        }

        req.setAttribute("pl", periodicalList);
        req.getRequestDispatcher("/mybox.jsp").forward(req, resp);

    }

}
