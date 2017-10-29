package com.epam.students.dao;

import org.h2.jdbcx.JdbcConnectionPool;
import org.h2.tools.RunScript;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPool {

    private static final ClassLoader classLoader = ConnectionPool.class.getClassLoader();
    private static JdbcConnectionPool connectionPool;

    public static synchronized JdbcConnectionPool getConnectionPool() {
        if (connectionPool == null) {
            Properties prop = new Properties();
            String filename = "db.properties";

            InputStream inputStream = classLoader.getResourceAsStream(filename);
            try {
                prop.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            connectionPool = JdbcConnectionPool.create(url, user, password);

            executeSchema("db_schema.sql", connectionPool);
            executeSchema("db_data.sql", connectionPool);
        }
        return connectionPool;
    }

    private static void executeSchema(String filename, JdbcConnectionPool connectionPool) {
        try (Connection conn = connectionPool.getConnection()) {
            URL resource = classLoader.getResource(filename);
            File file = new File(resource.toURI());
            RunScript.execute(conn, new FileReader(file));
        } catch (SQLException | URISyntaxException | FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}
