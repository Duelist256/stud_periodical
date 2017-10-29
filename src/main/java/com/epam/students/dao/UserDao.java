package com.epam.students.dao;


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
    public <T> User read(T email) {
        String query = "select * from inform_system.users where login = ?";
        User user = null;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, (String) email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();

                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setSalt(resultSet.getString("salt"));
                user.setName(resultSet.getString("name"));
                user.setIsAdmin(resultSet.getInt("isAdmin"));
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Fail to execute query");
            throw new RuntimeException(e);
        }

        return user;
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
