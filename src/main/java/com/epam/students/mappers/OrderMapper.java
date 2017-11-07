package com.epam.students.mappers;

import com.epam.students.model.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper {
    public static Order mapRow(ResultSet rs) throws SQLException {
        Order order = Order.newBuilder()
                .id(rs.getInt("id"))
                .idUser(rs.getInt("id_user"))
                .date(rs.getTimestamp("date_order"))
                .status(rs.getString("status"))
                .build();

        return order;
    }
}
