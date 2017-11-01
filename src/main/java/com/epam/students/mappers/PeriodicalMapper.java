package com.epam.students.mappers;

import com.epam.students.model.Periodical;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PeriodicalMapper {
    public static Periodical mapRow(ResultSet rs) throws SQLException {
        Periodical periodical = new Periodical();

        periodical.setId(rs.getInt("id"));
        periodical.setTitle(rs.getString("title"));
        periodical.setDescription(rs.getString("description"));
        periodical.setPublisher(rs.getString("publisher"));
        periodical.setGenre(rs.getString("genre"));
        periodical.setPrice(rs.getString("price"));
        periodical.setImgPath(rs.getString("img_path"));

        return periodical;
    }
}
