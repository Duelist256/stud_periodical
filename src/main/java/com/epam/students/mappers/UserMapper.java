package com.epam.students.mappers;

import com.epam.students.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {
    /**
     * Maps ResultSet object gotten from database into User object.
     * We can see Builder pattern here and its kinda nice.
     * And yes, I just copy-pasted this incredibly useful texts, who's gonna judge me?
     *
     * @param rs to base User object on.
     * @return User object based on result set.
     * @throws SQLException from result set data access methods.
     */
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
