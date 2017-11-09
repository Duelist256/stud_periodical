package com.epam.students.mappers;

import com.epam.students.model.OrderPeriodical;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderPeriodicalMapper {
    /**
     * Maps ResultSet object gotten from database into OrderPeriodical object.
     * We can see Builder pattern here and its kinda nice.
     *
     * @param rs to base OrderPeriodical object on.
     * @return OrderPeriodical object based on result set.
     * @throws SQLException from result set data access methods.
     */
    public static OrderPeriodical mapRow(ResultSet rs) throws SQLException {
        OrderPeriodical orderPeriodical = OrderPeriodical.newBuilder()
                .idOrder(rs.getInt("id_order"))
                .idPeriodical(rs.getInt("id_periodical"))
                .build();
        return orderPeriodical;
    }
}
