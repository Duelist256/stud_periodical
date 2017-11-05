package com.epam.students.dao;

import com.epam.students.model.Order;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class OrderDaoTest {

    @Test
    public void testCreate() throws Exception {
        OrderDao orderDao = new OrderDao();
        Order ordered = Order.newBuilder().idUser(1).date(new Timestamp(new Date().getTime())).status("Ordered").build();
        Order ordered1 = Order.newBuilder().idUser(1).date(new Timestamp(new Date().getTime())).status("Ordered").build();
        Order ordered2 = Order.newBuilder().idUser(2).date(new Timestamp(new Date().getTime())).status("Ordered").build();
        Order ordered3 = Order.newBuilder().idUser(3).date(new Timestamp(new Date().getTime())).status("Ordered").build();
        Order ordered4 = Order.newBuilder().idUser(1).date(new Timestamp(new Date().getTime())).status("Ordered").build();
        Order ordered5 = Order.newBuilder().idUser(2).date(new Timestamp(new Date().getTime())).status("Ordered").build();

        orderDao.create(ordered);
        orderDao.create(ordered1);
        orderDao.create(ordered2);
        orderDao.create(ordered3);
        orderDao.create(ordered4);
        orderDao.create(ordered5);

        orderDao.read(1);
        orderDao.read(2);
        orderDao.read(3);

        orderDao.getAll().forEach(t -> System.out.println(t.getId()));



    }

    @Test
    public void readTest() throws Exception {
        OrderDao orderDao = new OrderDao();
        Order ordered1 = Order.newBuilder().idUser(1).date(new Timestamp(new Date().getTime())).status("Ordered").build();
        Order ordered2 = Order.newBuilder().idUser(1).date(new Timestamp(new Date().getTime())).status("Ordered").build();
        orderDao.create(ordered1);
        orderDao.create(ordered2);
        orderDao.read(1);


    }

    @Test
    public void testDelete() throws Exception {
        OrderDao orderDao = new OrderDao();
        Order ordered1 = Order.newBuilder().idUser(1).date(new Timestamp(new Date().getTime())).status("Ordered").build();
        Order ordered2 = Order.newBuilder().idUser(1).date(new Timestamp(new Date().getTime())).status("Ordered").build();
        orderDao.delete(ordered1);
    }



    @Test
    public void testGetAll() throws Exception {
        OrderDao orderDao = new OrderDao();
        orderDao.getAll();
    }

    @Test
    public void updateTest() throws Exception {
        OrderDao orderDao = new OrderDao();
        Order ordered1 = Order.newBuilder().idUser(1).date(new Timestamp(new Date().getTime())).status("Sold").build();
        orderDao.update(ordered1);
    }

    @Test
    public void getAllByIdUserTest() throws Exception {
        OrderDao orderDao = new OrderDao();
        Order ordered1 = Order.newBuilder().idUser(1).date(new Timestamp(new Date().getTime())).status("Sold").build();
        Order ordered2 = Order.newBuilder().idUser(2).date(new Timestamp(new Date().getTime())).status("Sold").build();
        Order ordered3 = Order.newBuilder().idUser(3).date(new Timestamp(new Date().getTime())).status("Sold").build();
        Order ordered4 = Order.newBuilder().idUser(4).date(new Timestamp(new Date().getTime())).status("Sold").build();

        orderDao.create(ordered1);
        orderDao.create(ordered2);
        orderDao.create(ordered3);
        orderDao.create(ordered4);

        List<Order> allByIdUser = orderDao.getAllByIdUser(4);
    }

    @Test
    public void getOrderId() throws Exception {
        OrderDao orderDao = new OrderDao();
        Order ordered1 = Order.newBuilder().idUser(1).date(new Timestamp(new Date().getTime())).status("Sold").build();
        Order ordered2 = Order.newBuilder().idUser(2).date(new Timestamp(new Date().getTime())).status("Sold").build();
        Order ordered3 = Order.newBuilder().idUser(3).date(new Timestamp(new Date().getTime())).status("Sold").build();
        Order ordered4 = Order.newBuilder().idUser(4).date(new Timestamp(new Date().getTime())).status("Sold").build();

        orderDao.create(ordered1);
        orderDao.create(ordered2);
        orderDao.create(ordered3);
        orderDao.create(ordered4);

        int idOrder = orderDao.getLastIdOrder();
        System.out.println(idOrder);
    }
}