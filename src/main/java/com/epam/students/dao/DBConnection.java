package com.epam.students.dao;

import org.h2.jdbcx.JdbcConnectionPool;

import java.sql.Connection;

public class DBConnection {
    public static Connection getConnection() {
        JdbcConnectionPool cp = JdbcConnectionPool.create("jdbc:h2:file:C:/data/stud_project", "root", "1234");
        try {
            return cp.getConnection();
        } catch (Exception e) {
            throw new RuntimeException("Fail to connect");
        }
    }
}
