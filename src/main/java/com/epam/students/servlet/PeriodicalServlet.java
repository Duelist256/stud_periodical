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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String publisher = request.getParameter("publisher");
        String genre = request.getParameter("publisher");
        String price = request.getParameter("price");
        String imgPath = request.getParameter("img_path");

        Periodical periodical = Periodical.newBuilder()
                .title(title)
                .description(description)
                .publisher(publisher)
                .genre(genre)
                .price(price)
                .imgPath(imgPath)
                .build();

        periodicalService.addPeriodical(periodical);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PeriodicalService periodicalService = new PeriodicalService();
        List<Periodical> all = periodicalService.getAll();

        req.setAttribute("list", all);
        req.getRequestDispatcher("/listissue.jsp").forward(req, resp);

    }

}
