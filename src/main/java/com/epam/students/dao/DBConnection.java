package com.epam.students.dao;

import org.apache.log4j.Logger;
import org.h2.jdbcx.JdbcConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Class to provide static access to connection from connection pool.
 */
public class DBConnection {

    final static Logger logger = Logger.getLogger(DBConnection.class);

    /**
     * Method to provide static access to connection from connection pool.
     *
     * @return connection for database from pool.
     */
    public static Connection getConnection() {
        JdbcConnectionPool cp = ConnectionPool.getConnectionPool();
        try {
            return cp.getConnection();
        } catch (SQLException e) {
            logger.error("Failed to connect DB. Cause: " + e.getMessage());
            throw new RuntimeException();
        }
    }
}