package com.epam.students.dao;

import com.epam.students.model.OrderPeriodical;
import org.junit.Test;

public class OrderPeriodicalDaoTest {
    @Test
    public void create() throws Exception {
        OrderPeriodicalDao orderPeriodicalDao = new OrderPeriodicalDao();
        OrderPeriodical build = OrderPeriodical.newBuilder().idOrder(2).idPeriodical(2).build();
        OrderPeriodical build2 = OrderPeriodical.newBuilder().idOrder(1).idPeriodical(1).build();
        orderPeriodicalDao.create(build);
        orderPeriodicalDao.create(build2);
    }

    @Test
    public void update() throws Exception {
        OrderPeriodicalDao orderPeriodicalDao = new OrderPeriodicalDao();
        OrderPeriodical build = OrderPeriodical.newBuilder().idOrder(2).idPeriodical(2).build();
        OrderPeriodical build2 = OrderPeriodical.newBuilder().idOrder(1).idPeriodical(0).build();

        orderPeriodicalDao.update(build);
        orderPeriodicalDao.update(build2);

    }

    @Test
    public void delete() throws Exception {
        OrderPeriodicalDao orderPeriodicalDao = new OrderPeriodicalDao();
        OrderPeriodical build = OrderPeriodical.newBuilder().idOrder(42).idPeriodical(2).build();
        OrderPeriodical build2 = OrderPeriodical.newBuilder().idOrder(1).idPeriodical(0).build();

        orderPeriodicalDao.delete(build);
        orderPeriodicalDao.delete(build2);
    }

    @Test
    public void read() throws Exception {
        OrderPeriodicalDao orderPeriodicalDao = new OrderPeriodicalDao();
        OrderPeriodical build2 = OrderPeriodical.newBuilder().idOrder(1).idPeriodical(1).build();
        orderPeriodicalDao.read(build2.getIdOrder());
    }
}