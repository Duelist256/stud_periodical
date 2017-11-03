package com.epam.students.mappers;

import com.epam.students.model.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper {
    public static Order mapRow(ResultSet rs) throws SQLException {
        Order order = new Order();

        order.setIdUser(rs.getInt("id_user"));
        order.setData(rs.getDate("date_order"));
        order.setStatus(rs.getString("status"));

        return order;
    }
}
