package com.epam.students.dao;


import com.epam.students.mappers.PeriodicalMapper;
import com.epam.students.model.Periodical;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeriodicalDao implements Dao<Periodical> {

    @Override
    public void create(Periodical newUser) {
        throw new UnsupportedOperationException("Method isn't implemented yet");
    }

    @Override
    public Periodical read(String value) {
        throw new UnsupportedOperationException("Method isn't implemented yet");
    }

    @Override
    public void update(Periodical periodical) {
        throw new UnsupportedOperationException("Method isn't implemented yet");
    }

    @Override
    public void delete(Periodical periodical) {
        throw new UnsupportedOperationException("Method isn't implemented yet");
    }

    @Override
    public List<Periodical> getAll() {
        String query = "select * from inform_system.periodicals";
        PeriodicalMapper pm = new PeriodicalMapper();

        List<Periodical> periodicals = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Periodical periodical = pm.mapRow(resultSet);
                periodicals.add(periodical);
            }

        } catch (SQLException e) {
            System.out.println("Fail to execute query");
            throw new RuntimeException(e);
        }

        return periodicals;
    }
}
