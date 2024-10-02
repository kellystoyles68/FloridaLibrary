package com.keyin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteBook {

    private static final String URL = "jdbc:postgresql://localhost:5432/your_database_name";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        String sql = "DELETE FROM books WHERE title = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "Her Mothers Grave");
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Book 'Her Mothers Grave' deleted successfully!");
            } else {
                System.out.println("No book found with the title 'Her Mothers Grave'.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}