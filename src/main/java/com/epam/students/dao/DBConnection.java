package com.epam.students.dao;

import org.h2.jdbcx.JdbcConnectionPool;
import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {

    final static Logger logger = Logger.getLogger(DBConnection.class);

    public static Connection getConnection() {
        JdbcConnectionPool cp = ConnectionPool.getConnectionPool();
        try {
            return cp.getConnection();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new RuntimeException("Fail to connect");
        }
    }
}