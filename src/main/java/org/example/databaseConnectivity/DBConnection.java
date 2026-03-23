package org.example.databaseConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        try {

            String url = "jdbc:mysql://localhost:3306/library";
            String username = "root";
            String password = "pratyasham@09";

            Connection conn = DriverManager.getConnection(url, username, password);

            System.out.println("Database Connected Successfully!");

            return conn;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
