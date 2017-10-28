package com.epam.students.dao;

import org.h2.jdbcx.JdbcConnectionPool;

public class ConnectionPool {
    private static JdbcConnectionPool connectionPool;

    public static synchronized JdbcConnectionPool getConnectionPool() {
        if (connectionPool == null) {
            connectionPool = JdbcConnectionPool.create("jdbc:h2:file:C:/data/stud_project", "root", "1234");
        }
        return connectionPool;
    }
}
