package com.epam.students.servlet;

import com.epam.students.model.Periodical;
import com.epam.students.service.PeriodicalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PeriodicalServlet", urlPatterns = "/getall")
public class PeriodicalServlet extends HttpServlet {

    PeriodicalService periodicalService;

    public PeriodicalServlet(){
        periodicalService = new PeriodicalService();
    }

    protected void doPost(HttpServletRequest rs, HttpServletResponse response) throws ServletException, IOException {

        Periodical periodical = Periodical.newBuilder()
                .title(rs.getParameter("title"))
                .description(rs.getParameter("description"))
                .publisher(rs.getParameter("publisher"))
                .genre(rs.getParameter("publisher"))
                .price(rs.getParameter("price"))
                .imgPath(rs.getParameter("img_path"))
                .build();

        periodicalService.addPeriodical(periodical);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PeriodicalService periodicalService = new PeriodicalService();
        List<Periodical> all = periodicalService.getAll();

        req.setAttribute("list", all);
        req.getRequestDispatcher("/issue.jsp").forward(req, resp);

    }
}
