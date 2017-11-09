package com.epam.students.servlet;

import com.epam.students.dao.OrderDao;
import com.epam.students.dao.OrderPeriodicalDao;
import com.epam.students.dao.PeriodicalDao;
import com.epam.students.model.Order;
import com.epam.students.model.OrderPeriodical;
import com.epam.students.model.Periodical;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

@WebServlet(name = "BoxServlet", urlPatterns = "/mybox")
public class BoxServlet extends HttpServlet {
    private List<Periodical> periodicalList = new ArrayList<>();

    private int idUser;
    private OrderDao orderDao = new OrderDao();
    private OrderPeriodicalDao orderPeriodicalDao = new OrderPeriodicalDao();
    private PeriodicalDao periodicalDao = new PeriodicalDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        periodicalList.clear();

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookieReq : cookies) {
                if (cookieReq.getName().equals("userId")) {
                    idUser = Integer.valueOf(cookieReq.getValue());
                }
            }
        }

        List<Order> allByIdUser = orderDao.getAllByIdUser(idUser);
        if (!allByIdUser.isEmpty()) {
            for (Order order : allByIdUser) {
                if (order.getStatus().equals("Ordered")) {
                    OrderPeriodical orderPeriodical = orderPeriodicalDao.read(order.getId());
                    if (orderPeriodical != null) {
                        int idPeriodical = orderPeriodical.getIdPeriodical();
                        Periodical periodical = periodicalDao.read(idPeriodical);
                        periodicalList.add(periodical);
                    }
                }
            }
        }
        req.setAttribute("pl", periodicalList);
        req.getRequestDispatcher("/mybox.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("buy") != null) {
            List<OrderPeriodical> all = orderPeriodicalDao.getAll();
            if (!all.isEmpty()) {
                for (OrderPeriodical orderPeriodical : all) {
                    if (orderPeriodical != null) {
                        int idOrder = orderPeriodical.getIdOrder();
                        if (orderDao.read(idOrder).getIdUser() == idUser && !orderDao.read(idOrder).getStatus().equals("Delete")) {

                            Order order = Order.newBuilder()
                                    .id(orderPeriodical.getIdOrder())
                                    .idUser(idUser)
                                    .date(orderDao.read(idOrder).getDate())
                                    .status("Done")
                                    .build();
                            orderDao.update(order);
                        }
                    }
                }
            }
            periodicalList.clear();
            resp.sendRedirect("/mybox.jsp");


        } else {
            int delete = Integer.valueOf(req.getParameter("delete"));
            for (Periodical periodical : periodicalList) {
                if (periodical.getId() == delete) {
                    periodicalList.remove(periodical);
                    break;
                }
            }
            List<OrderPeriodical> all = orderPeriodicalDao.getAll();
            for (OrderPeriodical orderPeriodical : all) {
                if (orderPeriodical.getIdPeriodical() == delete && orderDao.read(orderPeriodical.getIdOrder()).getStatus().equals("Ordered")) {

                    Order order = Order.newBuilder()
                            .id(orderPeriodical.getIdOrder())
                            .idUser(idUser)
                            .date(orderDao.read(orderPeriodical.getIdOrder()).getDate())
                            .status("Delete")
                            .build();
                    orderDao.update(order);
                    break;
                }
            }
            req.setAttribute("pl", periodicalList);
            req.getRequestDispatcher("/mybox.jsp").forward(req, resp);
        }
    }
}


