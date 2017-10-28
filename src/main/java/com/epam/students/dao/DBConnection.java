package com.epam.students.dao;

import org.h2.jdbcx.JdbcConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() {
        JdbcConnectionPool cp = ConnectionPool.getConnectionPool();
        try {
            return cp.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Fail to connect");
        }
    }
}
