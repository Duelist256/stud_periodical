package com.epam.students.servlet;

import com.epam.students.dao.OrderDao;
import com.epam.students.dao.OrderPeriodicalDao;
import com.epam.students.dao.PeriodicalDao;
import com.epam.students.model.Order;
import com.epam.students.model.OrderPeriodical;
import com.epam.students.model.Periodical;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PurchasesServlet", urlPatterns = "/mypurchases")
public class PurchasesServlet extends HttpServlet {

    private List<Periodical> periodicalBought = new ArrayList<>();
    private OrderDao orderDao = new OrderDao();
    private OrderPeriodicalDao orderPeriodicalDao = new OrderPeriodicalDao();
    private PeriodicalDao periodicalDao = new PeriodicalDao();
    private HttpSession session;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        periodicalBought.clear();
        int idUser = 0;

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
                if (order.getStatus().equals("Done")) {
                    if (order != null) {
                        OrderPeriodical read = orderPeriodicalDao.read(order.getId());
                        periodicalBought.add(periodicalDao.read(read.getIdPeriodical()));
                    }
                }
            }
        }
        req.setAttribute("pb", periodicalBought);
        req.getRequestDispatcher("/storyPurchases.jsp").forward(req, resp);
    }
}
