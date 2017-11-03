package com.epam.students.dao;

import com.epam.students.model.OrderPeriodical;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderPeriodicalDao implements Dao<OrderPeriodical> {
    private final static Logger logger = Logger.getLogger(UserDao.class);


    @Override
    public void create(OrderPeriodical orderPeriodical) {
        String query = "INSERT INTO inform_system.orderPeriodical " +
                "(id_order, id_periodical) VALUES (?,?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1,orderPeriodical.getId_order());
            preparedStatement.setInt(2, orderPeriodical.getId_periodical());
            preparedStatement.executeUpdate();

            logger.info("New order of periodical successfully added");
        } catch (SQLException e) {
            logger.error("Failed to create order of periodical. Cause: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public OrderPeriodical read(int id) {
        return null;
    }

    @Override
    public void update(OrderPeriodical orderPeriodical) {
        String query = "UPDATE inform_system.orderPeriodical " +
                "SET id_periodical = ?" +
                "WHERE id_order = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, orderPeriodical.getId_periodical());
            preparedStatement.setInt(2, orderPeriodical.getId_order());


            preparedStatement.executeUpdate();
            logger.info("Order periodical \"" + orderPeriodical.getId_periodical() + "\" by "
                    + orderPeriodical.getId_order() + " successfully updated");
        } catch (SQLException e) {
            logger.error("Failed to update periodical. Cause: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(OrderPeriodical orderPeriodical) {
        String query = "DELETE FROM inform_system.orderPeriodical WHERE id_order = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, orderPeriodical.getId_order());
            preparedStatement.executeUpdate();

            logger.info("Order Periodical \"" + orderPeriodical.getId_order() + "\" with "
                    + orderPeriodical.getId_periodical() + " successfully deleted");
        } catch (SQLException e) {
            logger.error("Failed to delete periodical. Cause: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<OrderPeriodical> getAll() {
        return null;
    }
}