package com.epam.students.mappers;

import com.epam.students.model.OrderPeriodical;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderPeriodicalMapper {
    public static OrderPeriodical mapRow(ResultSet rs) throws SQLException {
        OrderPeriodical orderPeriodical = OrderPeriodical.newBuilder()
                .idOrder(rs.getInt("id_order"))
                .idPeriodical(rs.getInt("id_periodical"))
                .build();
        return orderPeriodical;
    }
}
