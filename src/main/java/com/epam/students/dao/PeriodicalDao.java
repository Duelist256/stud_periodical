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
        String query = "insert into inform_system.periodicals " +
                "(title, description, publisher, genre, price, img_path) " +
                "values (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, newPeriodical.getTitle());
            preparedStatement.setString(2, newPeriodical.getDescription());
            preparedStatement.setString(3, newPeriodical.getPublisher());
            preparedStatement.setString(4, newPeriodical.getGenre());
            preparedStatement.setString(5, newPeriodical.getPrice());
            preparedStatement.setString(6, newPeriodical.getImgPath());
            preparedStatement.executeUpdate();

            logger.info("New periodical successfully added");
        } catch (SQLException e) {
            logger.error("Failed to create periodical. Cause: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Periodical read(int id) {
        throw new UnsupportedOperationException("Method isn't implemented yet");
    }

    @Override
    public void update(Periodical periodical) {
        throw new UnsupportedOperationException("Method isn't implemented yet");
    }

    @Override
    public void delete(Periodical periodical) {
        String query = "DELETE FROM inform_system.periodicals WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, periodical.getId());
            preparedStatement.executeUpdate();
            logger.info("Periodical \"" + periodical.getTitle() + "\" by " + periodical.getPublisher() + " successfully deleted");
        } catch (SQLException e) {
            logger.error("Failed to delete periodical. Cause: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Periodical> getAll() {
        String query = "select * from inform_system.periodicals";

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
}
