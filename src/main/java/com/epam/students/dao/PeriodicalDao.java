package com.epam.students.dao;


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

        List<Periodical> periodicals = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Periodical periodical = new Periodical();

                periodical.setId(resultSet.getInt("id"));
                periodical.setTitle(resultSet.getString("title"));
                periodical.setDescription(resultSet.getString("description"));
                periodical.setPublisher(resultSet.getString("publisher"));
                periodical.setGenre(resultSet.getString("genre"));
                periodical.setPrice(resultSet.getString("price"));
                periodical.setImgPath(resultSet.getString("imgpath"));

                periodicals.add(periodical);
            }

        } catch (SQLException e) {
            System.out.println("Fail to execute query");
            throw new RuntimeException(e);
        }

        return periodicals;
    }
}
