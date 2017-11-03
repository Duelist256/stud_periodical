package com.epam.students.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderPeriodicalDao implements Dao {
    private final static Logger logger = Logger.getLogger(UserDao.class);

    @Override
    public void create(Object newOrder) {
//        String query = "insert into inform_system.orderPeriodical "+
//                " (id_order, id_periodical) values (?,?)";
//
//        try (Connection connection = DBConnection.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//            preparedStatement.setString(1, newOrder.);
//              preparedStatement.setString(6, );
//            preparedStatement.executeUpdate();
//
//            logger.info("New periodical successfully added");
//        } catch (SQLException e) {
//            logger.error("Failed to create periodical. Cause: " + e);
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public Object read(int id) {
        return null;
        //
    }

    @Override
    public void update(Object item) {

    }

    @Override
    public void delete(Object item) {
    //
    }

    @Override
    public List getAll() {
        return null;
    }
}
