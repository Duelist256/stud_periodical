package com.epam.students.dao;

import org.h2.jdbcx.JdbcConnectionPool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConnectionPool {
    private static JdbcConnectionPool connectionPool;

    public static synchronized JdbcConnectionPool getConnectionPool() {
        if (connectionPool == null) {
            Properties prop = new Properties();
            String filename = "db.properties";

            InputStream inputStream =
                    ConnectionPool.class.getClassLoader().getResourceAsStream(filename);
            try {
                prop.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            connectionPool = JdbcConnectionPool
                    .create("jdbc:h2:file:." + url + ";IFEXISTS=true", user, password);
        }
        return connectionPool;
    }
}
