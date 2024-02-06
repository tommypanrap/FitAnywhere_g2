package com.fitanywhere.defaultfuction;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//這個我只是要按一下執行就能快速確認有無和mySQL連線成功

public class ConnectionTest {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_test", "root", "123456");
            System.out.println("Connection to database established successfully.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error loading JDBC driver: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing database connection: " + e.getMessage());
            }
        }
    }
}

