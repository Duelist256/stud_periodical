package com.epam.students.mappers;

import com.epam.students.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {
    public static User mapRow(ResultSet rs) throws SQLException {
        User user = User.newBuilder()
                .id(rs.getInt("id"))
                .login(rs.getString("login"))
                .password(rs.getString("password"))
                .salt(rs.getString("salt"))
                .name(rs.getString("name"))
                .isAdmin(rs.getInt("isAdmin"))
                .build();

        return user;
    }
}
