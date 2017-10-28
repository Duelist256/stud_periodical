package com.epam.students.dao;


import com.epam.students.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {


    public boolean isUserCorrect(String login, String password) {

        if (login == null || password == null) {
            return false;
        }

        String query = "select id from inform_system.users where login = ? and password = ?";
        int result = 0;

        try (Connection connection = DBConnection.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result = resultSet.getInt("id");
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Fail to execute query");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return result != 0;
    }

    public String getSaltByLogin(String login) {

        if (login == null) {
            throw new NullPointerException("Login is null");
        }

        String query = "select salt from inform_system.users where login = ?";
        String result = null;

        try (Connection connection = DBConnection.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, login);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                result = resultSet.getString("salt");
            } else {
                return "no user";
            }

        } catch (SQLException e) {
            System.out.println("Fail to execute query");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        if (result != null) {
            return result;
        } else {
            throw new RuntimeException("No salt");
        }
    }


    public void addUser(User newUser) {

        String query = "insert into inform_system.users (name, login, password, salt) values (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
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
}
