package com.epam.students.servlet;

import com.epam.students.model.Periodical;
import com.epam.students.service.PeriodicalService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet", urlPatterns = "/showissue")
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PeriodicalService periodicalService = new PeriodicalService();
        List<Periodical> all = periodicalService.getAll();
//        req.setAttribute("list", all);
//        req.getServletContext().getRequestDispatcher("/admin.jsp").forward(req, resp);


        Gson gson = new GsonBuilder().create();
        JsonArray asJsonArray = gson.toJsonTree(all).getAsJsonArray();

        //resp.setContentType("admin.jsp");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(String.valueOf(asJsonArray));

//        req.setAttribute("list", asJsonArray);
//        req.getServletContext().getRequestDispatcher("/mybox.jsp").forward(req, resp);
    }
}

