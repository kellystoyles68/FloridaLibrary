package com.keyin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookInserter {

    private static final String URL = "jdbc:postgresql://localhost:5432/My_Florida_Library";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        String sql = "INSERT INTO books (ISBN, title, author, genre, year_published) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {


            insertBook(pstmt, 9781987149673L, "Santa Cruise", "Fern Micheals", "romance", 2021);
            insertBook(pstmt, 1397814967327L, "All I want from Santa", "Lisa Jackson", "thriller", 2021);
            insertBook(pstmt, 9781447257073L, "The Italian Girl", "Lucinda Riley", "mystery", 2014);
            insertBook(pstmt, 9781473622906L, "Rogue Lawyer", "John Grisham", "thriller", 2015);
            insertBook(pstmt, 9781509974411L, "The Girl on the Train", "Paula Hawkins", "thriller", 2015);
            insertBook(pstmt, 9781455585342L, "The Games", "John Grisham", "thriller", 2016);
            insertBook(pstmt, 9781668034477L, "Highland Scandal", "Julia London", "romance", 2009);
            insertBook(pstmt, 9781538726399L, "The Survivor", "Iris Johansen", "mystery", 2009);
            insertBook(pstmt, 9781538701249L, "Her Mothers Grave", "Lisa Regan", "thriller", 2020);

            System.out.println("Books inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertBook(PreparedStatement pstmt, long ISBN, String title, String author, String genre, int yearPublished) throws SQLException {
        pstmt.setLong(1, ISBN);
        pstmt.setString(2, title);
        pstmt.setString(3, author);
        pstmt.setString(4, genre);
        pstmt.setInt(5, yearPublished);
        pstmt.executeUpdate();
    }
}