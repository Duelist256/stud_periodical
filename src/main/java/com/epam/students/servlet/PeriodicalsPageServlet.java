package com.epam.students.servlet;

import com.epam.students.model.Periodical;
import com.epam.students.service.PeriodicalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PeriodicalPageServlet", urlPatterns = "/page")
public class PeriodicalsPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PeriodicalService periodicalService = new PeriodicalService();
        String parameter = req.getParameter("num");
        int pageNum = Integer.parseInt(parameter);

        List<Periodical> resultPage = periodicalService.getPage(pageNum, 10);

        req.setAttribute("list", resultPage);
        req.getRequestDispatcher("/issue.jsp").forward(req, resp);
    }
}
