package com.epam.students.dao;

import com.epam.students.mappers.OrderPeriodicalMapper;
import com.epam.students.model.OrderPeriodical;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderPeriodicalDao implements Dao<OrderPeriodical> {
    private final static Logger logger = Logger.getLogger(OrderPeriodicalDao.class);


    @Override
    public void create(OrderPeriodical orderPeriodical) {
        String query = "INSERT INTO inform_system.orderPeriodical (id_order, id_periodical) VALUES (?,?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, orderPeriodical.getIdOrder());
            preparedStatement.setInt(2, orderPeriodical.getIdPeriodical());
            preparedStatement.executeUpdate();

            logger.info("New order of periodical successfully added");
        } catch (SQLException e) {
            logger.error("Failed to create order of periodical. Cause: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public OrderPeriodical read(int id) {
        String query = "SELECT * FROM inform_system.orderPeriodical WHERE id_order = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                OrderPeriodical orderPeriodical = OrderPeriodicalMapper.mapRow(resultSet);
                logger.info("Order " + orderPeriodical.getIdOrder() + " of periodical " + orderPeriodical.getIdPeriodical() + " successfully read");
                return orderPeriodical;
            } else {
                return null;
            }
        } catch (SQLException e) {
            logger.error("Failed to read periodicals order. Cause: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(OrderPeriodical orderPeriodical) {
        String query = "UPDATE inform_system.orderPeriodical SET id_periodical = ? WHERE id_order = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, orderPeriodical.getIdPeriodical());
            preparedStatement.setInt(2, orderPeriodical.getIdOrder());

            preparedStatement.executeUpdate();
            logger.info("Order periodical " + orderPeriodical.getIdPeriodical() + " by "
                    + orderPeriodical.getIdOrder() + " successfully updated");
        } catch (SQLException e) {
            logger.error("Failed to update periodical. Cause: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(OrderPeriodical orderPeriodical) {
        String query = "DELETE FROM inform_system.orderPeriodical WHERE id_periodical = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, orderPeriodical.getIdPeriodical());
            preparedStatement.executeUpdate();

            logger.info("Order Periodical" + orderPeriodical.getIdOrder() + " with "
                    + orderPeriodical.getIdPeriodical() + " successfully deleted");
        } catch (SQLException e) {
            logger.error("Failed to delete periodical. Cause: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<OrderPeriodical> getAll() {
        String query = "SELECT * FROM inform_system.orderPeriodical";

        List<OrderPeriodical> orderList = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                OrderPeriodical order = OrderPeriodicalMapper.mapRow(resultSet);
                orderList.add(order);
            }
            logger.info("OrdersPeriodicals successfully gotten");

        } catch (SQLException e) {
            logger.error("Failed to get orders. Cause: " + e);
            throw new RuntimeException(e);
        }
        return orderList;
    }


}