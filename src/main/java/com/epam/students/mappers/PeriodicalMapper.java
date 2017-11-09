package com.epam.students.mappers;

import com.epam.students.model.Periodical;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PeriodicalMapper {
    /**
     * Maps ResultSet object gotten from database into Periodical object.
     * We can see Builder pattern here and its kinda nice.
     *
     * @param rs to base Periodical object on.
     * @return Periodical object based on result set.
     * @throws SQLException from result set data access methods.
     */
    public static Periodical mapRow(ResultSet rs) throws SQLException {
        Periodical periodical = Periodical.newBuilder()
                .id(rs.getInt("id"))
                .title(rs.getString("title"))
                .description(rs.getString("description"))
                .publisher(rs.getString("publisher"))
                .genre(rs.getString("genre"))
                .price(rs.getFloat("price"))
                .imgPath(rs.getString("img_path"))
                .build();

        return periodical;
    }
}
