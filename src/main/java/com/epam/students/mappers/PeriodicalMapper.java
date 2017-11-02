package com.epam.students.mappers;

import com.epam.students.model.Periodical;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PeriodicalMapper {
    public static Periodical mapRow(ResultSet rs) throws SQLException {
        Periodical periodical = new Periodical.Builder()

        .id(rs.getInt("id"))
        .title(rs.getString("title"))
        .description(rs.getString("description"))
        .publisher(rs.getString("publisher"))
        .genre(rs.getString("genre"))
        .price(rs.getString("price"))
        .imgPath(rs.getString("img_path"))
        .build();

        return periodical;
    }
}
