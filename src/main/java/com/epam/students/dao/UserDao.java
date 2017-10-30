package com.epam.students.dao;


import com.epam.students.mappers.UserMapper;
import com.epam.students.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao implements Dao<User> {

    @Override
    public void create(User newUser) {
        String query = "insert into inform_system.users (name, login, password, salt) values (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, newUser.getName());
            preparedStatement.setString(2, newUser.getLogin());
            preparedStatement.setString(3, newUser.getPassword());
            preparedStatement.setString(4, newUser.getSalt());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Fail to execute query");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public User read(String email) {
        String query = "select * from inform_system.users where login = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new UserMapper().mapRow(resultSet);
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Fail to execute query");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {
        throw new UnsupportedOperationException("Method isn't implemented yet");
    }

    @Override
    public void delete(User user) {
        throw new UnsupportedOperationException("Method isn't implemented yet");
    }

    @Override
    public List<User> getAll() {
        throw new UnsupportedOperationException("Method isn't implemented yet");
    }
}
