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

@WebServlet(name = "BoxServlet", urlPatterns = "/mybox")
public class BoxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        BuyServlet buyServlet = new BuyServlet();
//        List<Periodical> periodicalList = buyServlet.getPeriodicalList();
//        req.setAttribute("all",periodicalList);

        PeriodicalService periodicalService = new PeriodicalService();
        List<Periodical> all = periodicalService.getAll();
        req.setAttribute("list", all);
//
        req.getRequestDispatcher("/mybox.jsp").forward(req, resp);

    }

}
