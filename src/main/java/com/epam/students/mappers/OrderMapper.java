package com.epam.students.mappers;

import com.epam.students.model.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper {
    /**
     * Maps ResultSet object gotten from database into Order object.
     * We can see Builder pattern here and its kinda nice.
     *
     * @param rs to base Order object on.
     * @return Order object based on result set.
     * @throws SQLException from result set data access methods.
     */
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
