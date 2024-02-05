package com.fitanywhere.defaultfuction;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;


// JDBC直連式

public class DatabaseManager {
	
//	連結到的是測試用的project_test
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/project_test";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "123456";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}


