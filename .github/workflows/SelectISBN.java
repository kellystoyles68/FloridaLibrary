package com.keyin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectISBN {

    private static final String URL = "jdbc:postgresql://localhost:5432/your_database_name";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        String sql = "SELECT ISBN FROM books";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                long isbn = rs.getLong("ISBN");
                System.out.println("ISBN: " + isbn);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}