package com.epam.students.servlet;

import com.epam.students.dao.OrderDao;
import com.epam.students.dao.OrderPeriodicalDao;
import com.epam.students.dao.PeriodicalDao;
import com.epam.students.model.Order;
import com.epam.students.model.OrderPeriodical;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet(name = "BuyServlet", urlPatterns = "/bought")
public class BuyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idUser = 0;

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookieReq : cookies) {
                if (cookieReq.getName().equals("userId")) {
                    idUser = Integer.valueOf(cookieReq.getValue());
                }
            }
        }
        int idPeriodical = Integer.valueOf(req.getParameter("id"));

        Order ordered = Order.newBuilder().idUser(idUser).date(new Timestamp(new Date().getTime())).status("Ordered").build();
        OrderDao orderDao = new OrderDao();
        orderDao.create(ordered);

        OrderPeriodical orderPeriodical = OrderPeriodical.newBuilder().idOrder(orderDao.getLastIdOrder()).idPeriodical(idPeriodical).build();
        OrderPeriodicalDao orderPeriodicalDao = new OrderPeriodicalDao();
        orderPeriodicalDao.create(orderPeriodical);

        resp.getWriter().write("Periodical " + new PeriodicalDao().read(idPeriodical).getTitle() + " added in your box");
    }
}
