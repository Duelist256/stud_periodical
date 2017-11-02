package com.epam.students.dao;


import com.epam.students.model.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao implements Dao<User> {

    private final static Logger logger = Logger.getLogger(UserDao.class);

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
            logger.info("User " + newUser.getLogin() + " successfully added;");

        } catch (SQLException e) {

            logger.error("Failed to create user. Cause: "+ e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public User read(String email) {
        String query = "select * from inform_system.users where login = ?";
        User user = null;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, (String) email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User.Builder().id(resultSet.getInt("id"))
                        .login(resultSet.getString("login"))
                        .password(resultSet.getString("password"))
                        .salt(resultSet.getString("salt"))
                        .name(resultSet.getString("name"))
                        .isAdmin(resultSet.getInt("isAdmin"))
                        .build();

            } else {
                return null;
            }

        } catch (SQLException e) {

            logger.error("Failed to read user data. Cause: "+ e.getMessage());
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