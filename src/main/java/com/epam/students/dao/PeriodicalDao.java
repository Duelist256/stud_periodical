package com.epam.students.dao;


import com.epam.students.mappers.PeriodicalMapper;
import com.epam.students.model.Periodical;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeriodicalDao implements Dao<Periodical> {

    private final static Logger logger = Logger.getLogger(UserDao.class);

    @Override

    public void create(Periodical newPeriodical) {
        String query = "INSERT INTO inform_system.periodicals " +
                "(title, description, publisher, genre, price, img_path) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, newPeriodical.getTitle());
            preparedStatement.setString(2, newPeriodical.getDescription());
            preparedStatement.setString(3, newPeriodical.getPublisher());
            preparedStatement.setString(4, newPeriodical.getGenre());
            preparedStatement.setString(5, newPeriodical.getPrice());
            preparedStatement.setString(6, newPeriodical.getImgPath());
            preparedStatement.executeUpdate();

            logger.info(String.format("New periodical \"%s\" by %s successfully added",
                    newPeriodical.getTitle(), newPeriodical.getPublisher()));
        } catch (SQLException e) {
            logger.error("Failed to create periodical. Cause: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Periodical read(int id) {
        String query = "SELECT * FROM inform_system.periodicals WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Periodical periodical = PeriodicalMapper.mapRow(resultSet);
                logger.info(String.format("Periodical \"%s\" by %s successfully read",
                        periodical.getTitle(), periodical.getPublisher()));
                return periodical;
            } else {
                return null;
            }
        } catch (SQLException e) {
            logger.error("Failed to read periodical's data. Cause: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Periodical periodical) {
        String query = "UPDATE inform_system.periodicals " +
                "SET title = ?, description = ?, publisher = ?, " +
                "genre = ?, price = ?, img_path = ? " +
                "WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, periodical.getTitle());
            preparedStatement.setString(2, periodical.getDescription());
            preparedStatement.setString(3, periodical.getPublisher());
            preparedStatement.setString(4, periodical.getGenre());
            preparedStatement.setString(5, periodical.getPrice());
            preparedStatement.setString(6, periodical.getImgPath());
            preparedStatement.setInt(7, periodical.getId());

            preparedStatement.executeUpdate();
            logger.info(String.format("Periodical \"%s\" by %s successfully updated",
                    periodical.getTitle(), periodical.getPublisher()));
        } catch (SQLException e) {
            logger.error("Failed to update periodical. Cause: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Periodical periodical) {
        String query = "DELETE FROM inform_system.periodicals WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, periodical.getId());
            preparedStatement.executeUpdate();
            logger.info(String.format("Periodical \"%s\" by %s successfully deleted",
                    periodical.getTitle(), periodical.getPublisher()));
        } catch (SQLException e) {
            logger.error("Failed to delete periodical. Cause: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Periodical> getAll() {
        String query = "SELECT * FROM inform_system.periodicals";

        List<Periodical> periodicals = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Periodical periodical = PeriodicalMapper.mapRow(resultSet);
                periodicals.add(periodical);
            }

            logger.info("Periodicals successfully gotten");

        } catch (SQLException e) {
            logger.error("Failed to get periodicals. Cause: " + e);
            throw new RuntimeException(e);
        }

        return periodicals;
    }

    public List<Periodical> getPaged(int page, int size){
        int first = (page - 1) * size;
        String query = "select * from inform_system.periodicals where id limit " + first + "," + size + ";";
        List<Periodical> result = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Periodical periodical = PeriodicalMapper.mapRow(resultSet);
                result.add(periodical);
            }

            logger.info("Periodicals successfully gotten");

        } catch (SQLException e) {
            logger.error("Failed to get periodicals. Cause: " + e);
            throw new RuntimeException(e);
        }

        return  result;
    }
}
