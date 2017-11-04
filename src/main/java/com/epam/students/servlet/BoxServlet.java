package com.epam.students.servlet;

import com.epam.students.dao.OrderDao;
import com.epam.students.dao.OrderPeriodicalDao;
import com.epam.students.dao.PeriodicalDao;
import com.epam.students.model.Order;
import com.epam.students.model.OrderPeriodical;
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
   List<Periodical> periodicalList = new ArrayList<>();
   int idUser;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        periodicalList.clear();

        Cookie[] cookies = req.getCookies();
        if(cookies != null) {
            for (Cookie cookieReq : cookies) {
                if (cookieReq.getName().equals("userId")) {
                    idUser = Integer.valueOf(cookieReq.getValue());
                }
            }
        }

        OrderDao orderDao = new OrderDao();
        OrderPeriodicalDao orderPeriodicalDao = new OrderPeriodicalDao();
        PeriodicalDao periodicalDao = new PeriodicalDao();

        List<Order> allByIdUser = orderDao.getAllByIdUser(idUser);

        orderDao.getAll().forEach(t -> System.out.println(t.getId() + " " + t.getDate()));

        for (Order order: allByIdUser){
            int id = order.getId();
            OrderPeriodical orderPeriodical = orderPeriodicalDao.read(id);
            int idPeriodical = orderPeriodical.getIdPeriodical();
            Periodical periodical = periodicalDao.read(idPeriodical);
            periodicalList.add(periodical);
        }

        //allByIdUser.forEach(t ->periodicalList.add(periodicalDao.read(orderPeriodicalDao.read(t.getId()).getIdPeriodical())));


//        for(Cookie cookie : cookies){
//            if (cookie.getName().startsWith("id")) {
//                periodicalList.add(new PeriodicalDao().read(Integer.valueOf(cookie.getValue())));
//                continue;
//            }
//        }

        req.setAttribute("pl", periodicalList);
        req.getRequestDispatcher("/mybox.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Cookie[] cookies = req.getCookies();
        String deleteID = req.getParameter("delete");

        for(Cookie cookie : cookies){
            if (cookie.getValue().equals(deleteID)) {
                cookie.setPath("/");
                cookie.setValue("");
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
                break;
            }
        }
        req.setAttribute("pl", periodicalList);
        req.getRequestDispatcher("/mybox.jsp").forward(req, resp);

    }




}
