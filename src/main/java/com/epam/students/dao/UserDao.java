package com.epam.students.dao;


import com.epam.students.mappers.UserMapper;
import com.epam.students.model.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao<User> {

    private final static Logger logger = Logger.getLogger(UserDao.class);

    @Override
    public void create(User newUser) {
        String query =
                "insert into inform_system.users (name, login, password, salt) values (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, newUser.getName());
            preparedStatement.setString(2, newUser.getLogin());
            preparedStatement.setString(3, newUser.getPassword());
            preparedStatement.setString(4, newUser.getSalt());
            preparedStatement.executeUpdate();
            logger.info("User " + newUser.getLogin() + " successfully added");

        } catch (SQLException e) {
            logger.error("Failed to create user. Cause: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public User read(String email) {
        String query = "select * from inform_system.users where login = ?";
        User user = null;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User.Builder().id(resultSet.getInt("id"))
                        .login(resultSet.getString("login"))
                        .password(resultSet.getString("password"))
                        .salt(resultSet.getString("salt"))
                        .name(resultSet.getString("name"))
                        .isAdmin(resultSet.getInt("isAdmin"))
                        .build();
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            logger.error("Failed to read user data. Cause: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {
        String query = "UPDATE inform_system.users " +
                "SET login = ?, password = ?, salt = ?, name = ? " +
                "WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getSalt());
            preparedStatement.setString(4, user.getName());
            preparedStatement.setInt(5, user.getId());

            preparedStatement.executeUpdate();
            logger.info("User " + user.getLogin() + " successfully updated");
        } catch (SQLException e) {
            logger.error("Failed to update user. Cause: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(User user) {
        String query = "DELETE FROM inform_system.users WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, user.getId());
            preparedStatement.executeUpdate();
            logger.info("User " + user.getLogin() + " successfully deleted");
        } catch (SQLException e) {
            logger.error("Failed to delete user. Cause: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAll() {
        String query = "select * from inform_system.users";

        List<User> users = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = UserMapper.mapRow(resultSet);
                users.add(user);
            }
            logger.info("Users successfully gotten");
        } catch (SQLException e) {
            logger.error("Failed to get users. Cause: " + e);
            throw new RuntimeException(e);
        }

        return users;
    }
}