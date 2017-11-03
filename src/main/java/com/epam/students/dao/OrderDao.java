package com.epam.students.dao;

import com.epam.students.mappers.OrderMapper;
import com.epam.students.mappers.PeriodicalMapper;
import com.epam.students.model.Order;
import com.epam.students.model.Periodical;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements Dao<Order> {

    private final static Logger logger = Logger.getLogger(OrderDao.class);

    @Override
    public void create(Order newOrder) {
        String query = "INSERT INTO inform_system.orders (id_user, date_order, status) VALUES (?,?,?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, String.valueOf(newOrder.getIdUser()));
            preparedStatement.setString(2, String.valueOf(newOrder.getDate()));
            preparedStatement.setString(3, newOrder.getStatus());
            preparedStatement.executeUpdate();

            logger.info("New order successfully added");
        } catch (SQLException e) {
            logger.error("Failed to create order. Cause: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Order read(int id) {
        String query = "SELECT * FROM inform_system.orders WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Order order = OrderMapper.mapRow(resultSet);
                logger.info("Order done " + order.getIdUser() + " by "
                        + order.getDate() + " successfully read");
                return order;
            } else {
                return null;
            }
        } catch (SQLException e) {
            logger.error("Failed to read order's data. Cause: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Order order) {
        String query = "UPDATE inform_system.orders " + "SET id_user = ?, date_order = ?, status = ? " +
                "WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, String.valueOf(order.getIdUser()));
            preparedStatement.setString(2, String.valueOf(order.getDate()));
            preparedStatement.setString(3, order.getStatus());
            preparedStatement.setString(4, String.valueOf(order.getId()));

            preparedStatement.executeUpdate();
            logger.info("Order " + order.getId() + " by "
                    + order.getIdUser() + " successfully updated");
        } catch (SQLException e) {
            logger.error("Failed to update order. Cause: " + e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Order order) {
        String query = "DELETE FROM inform_system.orders WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, order.getId());
            preparedStatement.executeUpdate();
            logger.info("Order id = " + order.getId() + " by user "
                    + order.getIdUser() + " successfully deleted");
        } catch (SQLException e) {
            logger.error("Failed to delete order. Cause: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> getAll() {
        String query = "SELECT * FROM inform_system.orders";

        List<Order> orderList = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Order order = OrderMapper.mapRow(resultSet);
                orderList.add(order);
            }
            logger.info("Orders successfully gotten");

        } catch (SQLException e) {
            logger.error("Failed to get orders. Cause: " + e);
            throw new RuntimeException(e);
        }
        return orderList;
    }
}
