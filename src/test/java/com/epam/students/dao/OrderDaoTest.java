package com.epam.students.dao;

import com.epam.students.model.Order;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class OrderDaoTest {

    @Test
    public void testCreate() throws Exception {
        OrderDao orderDao = new OrderDao();
        Order ordered = Order.newBuilder().idUser(1).date(new Timestamp(new Date().getTime())).status("Ordered").build();

        orderDao.create(ordered);

        Order order = orderDao.read(orderDao.getLastIdOrder());
        assertEquals(1, order.getIdUser());
        assertEquals("Ordered", order.getStatus());


    }

    @Test
    public void readTest() throws Exception {
        OrderDao orderDao = new OrderDao();
        Order ordered1 = Order.newBuilder().id(1).idUser(1).date(new Timestamp(new Date().getTime())).status("Wow").build();
        orderDao.create(ordered1);
        assertEquals("Wow", orderDao.read(orderDao.getLastIdOrder()).getStatus());


    }

    @Test
    public void testDelete() throws Exception {
        OrderDao orderDao = new OrderDao();
        Order ordered1 = Order.newBuilder().id(1).idUser(1).date(new Timestamp(new Date().getTime())).status("Ordered").build();
        orderDao.delete(ordered1);
    }


    @Test
    public void testGetAll() throws Exception {
        OrderDao orderDao = new OrderDao();
        List<Order> all = orderDao.getAll();
        assertFalse(all.isEmpty());

    }

    @Test
    public void getAllByIdUserTest() throws Exception {
        OrderDao orderDao = new OrderDao();
        Order ordered1 = Order.newBuilder().id(2).idUser(1).date(new Timestamp(new Date().getTime())).status("Sold").build();
        Order ordered2 = Order.newBuilder().idUser(2).date(new Timestamp(new Date().getTime())).status("Sold").build();

        orderDao.create(ordered1);
        orderDao.create(ordered2);
        List<Order> allByIdUser = orderDao.getAllByIdUser(4);
    }

    @Test
    public void getOrderId() throws Exception {
        OrderDao orderDao = new OrderDao();
        Order ordered1 = Order.newBuilder().idUser(1111).date(new Timestamp(new Date().getTime())).status("Sold").build();

        orderDao.create(ordered1);
        assertEquals(1111, orderDao.read(orderDao.getLastIdOrder()).getIdUser());


    }
}