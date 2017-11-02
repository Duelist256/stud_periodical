package com.epam.students.dao;

import org.h2.jdbcx.JdbcConnectionPool;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConnectionPoolTest {

    @Test
    public void checkThatGetConnectionReturnsSameObject() {
        JdbcConnectionPool cp1 = ConnectionPool.getConnectionPool();
        JdbcConnectionPool cp2 = ConnectionPool.getConnectionPool();
        assertEquals(cp1, cp2);
    }
}