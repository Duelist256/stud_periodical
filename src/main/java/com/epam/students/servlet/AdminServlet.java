package com.epam.students.servlet;

import com.epam.students.dao.PeriodicalDao;
import com.epam.students.model.Periodical;
import com.epam.students.service.PeriodicalService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/adminpage"})
public class AdminServlet extends javax.servlet.http.HttpServlet {

    private PeriodicalService periodicalService;

    public AdminServlet() {
        periodicalService = new PeriodicalService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

        String action = request.getParameter("action");

        try {

            if (action == null) {
                showPeriodicals(request, response);
            } else {
                switch (action) {
                    case "new":
                        showNewForm(request, response);
                        break;
                    case "insert":
                        insertPeriodical(request, response);
                        break;
                    case "edit":
                        showEditForm(request, response);
                        break;
                    case "update":
                        updatePeriodical(request, response);
                        break;
                    case "delete":
                        int id = Integer.parseInt(request.getParameter("delete"));
                        deletePeriodical(request, response, id);
                        break;
                }
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        doPost(request, response);
    }

    private void showPeriodicals(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Periodical> periodicals = periodicalService.getAll();
        request.setAttribute("periodicals", periodicals);
        RequestDispatcher dispatcher = request.getRequestDispatcher("adminpage.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("periodicalform.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Periodical periodical = periodicalService.getById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("periodicalform.jsp");
        request.setAttribute("periodical", periodical);
        dispatcher.forward(request, response);

    }

    private void insertPeriodical(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String publisher = request.getParameter("publisher");
        String genre = request.getParameter("genre");
        String price = request.getParameter("price");
        String imgPath = request.getParameter("imgPath");

        Periodical periodical = Periodical.newBuilder()
                .title(title)
                .description(description)
                .publisher(publisher)
                .genre(genre)
                .price(price)
                .imgPath(imgPath)
                .build();
        periodicalService.addPeriodical(periodical);
        response.sendRedirect("/adminpage");
    }

    private void updatePeriodical(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String publisher = request.getParameter("publisher");
        String genre = request.getParameter("genre");
        String price = request.getParameter("price");
        String imgPath = request.getParameter("imgPath");

        Periodical periodical = Periodical.newBuilder()
                .id(id)
                .title(title)
                .description(description)
                .publisher(publisher)
                .genre(genre)
                .price(price)
                .imgPath(imgPath)
                .build();
        periodicalService.updatePeriodical(periodical);
        response.sendRedirect("/adminpage");
    }

    private void deletePeriodical(HttpServletRequest request, HttpServletResponse response, int id)
            throws SQLException, IOException {
        Periodical periodical = Periodical.newBuilder().id(id).build();
        periodicalService.deletePeriodical(periodical);
        response.sendRedirect("/adminpage");

    }
}