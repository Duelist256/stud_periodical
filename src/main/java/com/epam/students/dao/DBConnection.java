package com.epam.students.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

public class DBConnection {
    public static Connection getConnection() {
        try {
            //loading drivers for mysql
//            Class.forName("com.mysql.jdbc.Driver");

            Context context = (Context) (new InitialContext().lookup("java:comp/env"));
            DataSource ds = (DataSource) context.lookup("jdbc/informsystem");
            //creating connection with the database
//            return DriverManager.
//                    getConnection("jdbc:mysql://localhost/inform_system", "root", "1234");
            return ds.getConnection();
        } catch (Exception e) {
            System.err.println("Fail to connect");
            return null;
        }
    }
}
