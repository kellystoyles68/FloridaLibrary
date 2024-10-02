package com.keyin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class CreateTable {

    private static final String URL = "jdbc:postgresql://localhost:5432/your_database_name";
    private static final String USER = "";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        String sql = "CREATE TABLE books ("
                + "ISBN BIGINT PRIMARY KEY, "
                + "title VARCHAR(255) NOT NULL, "
                + "author VARCHAR(250) NOT NULL, "
                + "genre VARCHAR(25) NOT NULL, "
                + "year_published INT NOT NULL"
                + ")";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Table 'books' created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}