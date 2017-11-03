package com.epam.students.dao;

import com.epam.students.model.OrderPeriodical;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderPeriodicalDaoTest {
    @Test
    public void create() throws Exception {
        OrderPeriodicalDao orderPeriodicalDao = new OrderPeriodicalDao();
        OrderPeriodical build = OrderPeriodical.newBuilder().id_order(2).id_periodical(2).build();
        OrderPeriodical build2 = OrderPeriodical.newBuilder().id_order(1).id_periodical(0).build();
        orderPeriodicalDao.create(build);
        orderPeriodicalDao.create(build2);
    }

    @Test
    public void update() throws Exception {
        OrderPeriodicalDao orderPeriodicalDao = new OrderPeriodicalDao();
        OrderPeriodical build = OrderPeriodical.newBuilder().id_order(2).id_periodical(2).build();
        OrderPeriodical build2 = OrderPeriodical.newBuilder().id_order(1).id_periodical(0).build();

        orderPeriodicalDao.update(build);
        orderPeriodicalDao.update(build2);

    }

    @Test
    public void delete() throws Exception {
        OrderPeriodicalDao orderPeriodicalDao = new OrderPeriodicalDao();
        OrderPeriodical build = OrderPeriodical.newBuilder().id_order(42).id_periodical(2).build();
        OrderPeriodical build2 = OrderPeriodical.newBuilder().id_order(1).id_periodical(0).build();

        orderPeriodicalDao.delete(build);
        orderPeriodicalDao.delete(build2);
    }

}