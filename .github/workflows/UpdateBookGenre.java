package com.keyin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateBookGenre {

    private static final String URL = "jdbc:postgresql://localhost:5432/your_database_name";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        String sql = "UPDATE books SET genre = ? WHERE ISBN = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "mystery");
            pstmt.setLong(2, 139781496732927L);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Book genre updated successfully!");
            } else {
                System.out.println("No book found with the specified ISBN.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
