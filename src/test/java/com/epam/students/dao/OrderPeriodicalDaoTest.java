package com.epam.students.dao;

import com.epam.students.model.OrderPeriodical;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrderPeriodicalDaoTest {
    @Test
    public void create() throws Exception {
        OrderPeriodicalDao orderPeriodicalDao = new OrderPeriodicalDao();
        OrderPeriodical build = OrderPeriodical.newBuilder().idOrder(11).idPeriodical(2).build();

        orderPeriodicalDao.create(build);
        assertEquals(2, orderPeriodicalDao.read(11).getIdPeriodical());

    }

    @Test
    public void update() throws Exception {
        OrderPeriodicalDao orderPeriodicalDao = new OrderPeriodicalDao();
        OrderPeriodical build = OrderPeriodical.newBuilder().idOrder(2).idPeriodical(2).build();
        orderPeriodicalDao.create(build);

        OrderPeriodical build2 = OrderPeriodical.newBuilder().idOrder(2).idPeriodical(111).build();
        orderPeriodicalDao.update(build2);

        assertEquals(111, orderPeriodicalDao.read(2).getIdPeriodical());




    }

    @Test
    public void delete() throws Exception {
        OrderPeriodicalDao orderPeriodicalDao = new OrderPeriodicalDao();
        OrderPeriodical build = OrderPeriodical.newBuilder().idOrder(42).idPeriodical(2).build();
        orderPeriodicalDao.delete(build);

    }

    @Test
    public void read() throws Exception {
        OrderPeriodicalDao orderPeriodicalDao = new OrderPeriodicalDao();
        OrderPeriodical build = OrderPeriodical.newBuilder().idOrder(1).idPeriodical(12).build();
        orderPeriodicalDao.create(build);

        assertEquals(12, orderPeriodicalDao.read(1).getIdPeriodical());
    }

    @Test
    public void getAll() throws Exception {

        OrderPeriodicalDao orderPeriodicalDao = new OrderPeriodicalDao();
        OrderPeriodical build = OrderPeriodical.newBuilder().idOrder(42).idPeriodical(2).build();

        orderPeriodicalDao.create(build);
        List<OrderPeriodical> all = orderPeriodicalDao.getAll();
        //  orderPeriodicalDao.getAll().forEach(t -> System.out.println(t.getIdOrder() + " " + t.getIdPeriodical()));

        for(OrderPeriodical orderPeriodical : all){
            assertEquals(42, orderPeriodical.getIdOrder());
            assertEquals(2, orderPeriodical.getIdPeriodical());
        }

    }
}