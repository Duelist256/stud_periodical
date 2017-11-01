package com.epam.students.mappers;

import com.epam.students.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {
    public static User mapRow(ResultSet rs) throws SQLException {
        User user = new User();

        user.setId(rs.getInt("id"));
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
        user.setSalt(rs.getString("salt"));
        user.setName(rs.getString("name"));
        user.setIsAdmin(rs.getInt("isAdmin"));

        return user;
    }
}
